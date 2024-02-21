package com.retail.session.entities;

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
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence"

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_sequence"
    )
    private Long id;
    private String name;
}
