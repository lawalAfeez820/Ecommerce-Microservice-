package com.lawal.ecommerce.product;


import com.lawal.ecommerce.category.Category;
import com.lawal.ecommerce.exception.ProductNotFoundException;
import com.lawal.ecommerce.exception.ProductPurchaseException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public Integer createProduct(@Valid ProductRequest request) {

        Product product = productMapper.toProduct(request);

        return productRepository.save(product).getId();

    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) {

        List<Integer> productIds = request
                .stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();
        List<Product> storedProducts = productRepository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storedProducts.size())
            throw new ProductPurchaseException("One or more products does not exist");

        List<ProductPurchaseRequest> storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();

        List<ProductPurchaseResponse> productPurchaseResponses= new ArrayList<ProductPurchaseResponse>();

        for (int i = 0; i < storedProducts.size(); i++){
            Product product = storedProducts.get(i);
            ProductPurchaseRequest productRequest = storedRequest.get(i);

            if (product.getAvailableQuantity() < productRequest.getQuantity())
                throw new ProductPurchaseException("Insufficient stock quantity for product with Id:"
                        + productRequest.getProductId()
                        + ", There is just "
                        + product.getAvailableQuantity()
                        +" left");

            product.setAvailableQuantity(
                    product.getAvailableQuantity() - productRequest.getQuantity());

            Product newProduct = productRepository.save(product);

            productPurchaseResponses.add(productMapper.toProductPurchaseResponse(newProduct, productRequest.getQuantity()));


        }

        return productPurchaseResponses;

    }

    public ProductResponse findById(Integer productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException("No product with an id: "+ productId));

        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();

    }
}
