package com.retail.order.entiities;

import com.retail.customer.entities.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_id-S=sequence",
            sequenceName = "product"
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "order_id-S=sequence"
    )
    private Long id;
    private String date;
    private Long customerId;
}
