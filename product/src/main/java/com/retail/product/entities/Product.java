package com.retail.product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence"

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    private Long id;
    private String name;
    private String detail;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
