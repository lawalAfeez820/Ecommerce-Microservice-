package com.lawal.ecommerce.product;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lawal.ecommerce.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@SequenceGenerator(
        name = "product_seq",
        sequenceName = "product_seq",
        allocationSize = 1  // Set to 1 to increment by 1
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_seq")
    private Integer id;

    private String name;

    private String description;

    private double availableQuantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonBackReference
    private Category category;
}
