package com.lawal.ecommerce.product;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lawal.ecommerce.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {


    private Integer id;

    private String name;

    private String description;

    private double availableQuantity;

    private BigDecimal price;

    private Integer categoryId;

    private String categoryName;

    private String categoryDescription;

}
