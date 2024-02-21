package com.retail.session.entities;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
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
public class Size {
    @Id
    @SequenceGenerator(
            name = "size_id_sequence",
            sequenceName = "size_id_sequence"

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "size_id_sequence"
    )
    private Long id;
    private String name;
}
