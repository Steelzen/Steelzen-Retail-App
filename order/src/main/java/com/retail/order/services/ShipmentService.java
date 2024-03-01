package com.retail.order.services;

import com.retail.order.entiities.Order;
import com.retail.order.entiities.Shipment;
import com.retail.order.repositories.OrderRepository;
import com.retail.order.repositories.ShipmentRepository;
import com.retail.order.requests.ShipmentRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final OrderRepository orderRepository;

    public void registerShipment (ShipmentRegistrationRequest request) {
        Order order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Shipment shipment = Shipment.builder()
                .date(request.date())
                .order(order)
                .build();

        shipmentRepository.saveAndFlush(shipment);

    }

    public List<Shipment> getShipment () { return this.shipmentRepository.findAll(); }
}
