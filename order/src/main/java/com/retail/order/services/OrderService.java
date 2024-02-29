package com.retail.order.services;

import com.retail.order.entiities.Order;
import com.retail.order.repositories.OrderRepository;
import com.retail.order.requests.OrderRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void registerOrder (OrderRegistrationRequest request) {

        Order order = Order.builder()
                .date(request.date())
                .customerId(request.customerId())
                .build();

        orderRepository.saveAndFlush(order);
    }

    public List<Order> getOrder () { return this.orderRepository.findAll(); }
}
