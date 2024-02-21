package com.retail.session.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariant {
    @Id
    @SequenceGenerator(
            name = "product_variant_id_sequence",
            sequenceName = "product_variant_id_sequence"

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_variant_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    private Double price;
    private Integer stock;
}
