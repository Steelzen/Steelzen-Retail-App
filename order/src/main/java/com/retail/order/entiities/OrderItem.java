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
public class OrderItem {
    @Id
    @SequenceGenerator(
            name = "order_item_id_sequence",
            sequenceName = "order_item_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_id_sequence"
    )
    private Long id;
    private Integer quantity;
    private Double discount;
    private Long productVariantId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
