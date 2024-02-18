package com.retail.product.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @SequenceGenerator(
            name = "color_id_sequence",
            sequenceName = "color_id_sequence"

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "color_id_sequence"
    )
    private Long id;
    private String name;
}
