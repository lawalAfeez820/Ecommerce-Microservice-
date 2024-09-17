package com.lawal.ecommerce.category;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lawal.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@SequenceGenerator(
        name = "category_seq",
        sequenceName = "category_seq",
        allocationSize = 1  // Set to 1 to increment by 1
)
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "category_seq")
    private Integer id;

    private String name;

    private String description;


    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.REMOVE
    )
    @JsonManagedReference
    private List<Product> products;

}
