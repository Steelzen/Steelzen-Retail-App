package com.retail.order.services;

import com.retail.order.entiities.Order;
import com.retail.order.entiities.OrderItem;
import com.retail.order.repositories.OrderItemRepository;
import com.retail.order.repositories.OrderRepository;
import com.retail.order.requests.OrderItemRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    public void registerOrderItem (OrderItemRegistrationRequest request) {
        Order order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderItem orderItem = OrderItem.builder()
                .quantity(request.quantity())
                .discount(request.discount())
                .productVariantId(request.productVariantId())
                .order(order)
                .build();

        orderItemRepository.saveAndFlush(orderItem);
    }

    public List<OrderItem> getOrderItem() { return this.orderItemRepository.findAll(); }
}
