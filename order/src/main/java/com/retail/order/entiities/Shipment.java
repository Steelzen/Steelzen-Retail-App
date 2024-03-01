package com.retail.order.entiities;

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
public class Shipment {
    @Id
    @SequenceGenerator(
            name = "shipment_id_sequence",
            sequenceName = "shipment_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shipment_id_sequence"
    )
    private Long id;
    private String date;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
