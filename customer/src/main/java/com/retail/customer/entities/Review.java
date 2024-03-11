package com.retail.customer.entities;

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
public class Review {
    @Id
    @SequenceGenerator(
            name = "review_id_sequence",
            sequenceName = "review_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_id_sequence"
    )
    private Long id;
    private Integer grade;
    private String detail;
    private String imgURL;
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
