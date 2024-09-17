package com.lawal.ecommerce.product;

import com.lawal.ecommerce.category.Category;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ProductMapper {
    public Product toProduct(@Valid ProductRequest request) {

        return Product
                .builder()
                .price(request.getPrice())
                .availableQuantity(request.getAvailableQuantity())
                .name(request.getName())
                .description(request.getDescription())
                .category(Category.
                        builder()
                        .id(request.getCategoryId())
                        .build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {


        return ProductResponse
                .builder()
                .id(product.getId())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .categoryDescription(product.getCategory().getDescription())
                .categoryName(product.getCategory().getName())
                .description(product.getDescription())
                .name(product.getName())
                .build();
    }


    public ProductPurchaseResponse toProductPurchaseResponse(Product newProduct, Double quantity) {

        return ProductPurchaseResponse
                .builder()
                .productId(newProduct.getId())
                .description(newProduct.getDescription())
                .name(newProduct.getName())
                .quantityBought(quantity)
                .pricePerOne(newProduct.getPrice())
                .totalPrice(newProduct.getPrice().multiply(BigDecimal.valueOf(quantity)))
                .build();



    }
}
