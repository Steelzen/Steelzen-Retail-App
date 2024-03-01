package com.retail.order;

import com.retail.order.entiities.Order;
import com.retail.order.entiities.OrderItem;
import com.retail.order.entiities.Shipment;
import com.retail.order.requests.OrderItemRegistrationRequest;
import com.retail.order.requests.OrderRegistrationRequest;
import com.retail.order.requests.ShipmentRegistrationRequest;
import com.retail.order.services.OrderItemService;
import com.retail.order.services.OrderService;
import com.retail.order.services.ShipmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ShipmentService shipmentService;
    private final OrderItemService orderItemService;

    @PostMapping
    public void registerOrder (@RequestBody OrderRegistrationRequest orderRegistrationRequest) {
        log.info("new order registration {}", orderRegistrationRequest);
        orderService.registerOrder(orderRegistrationRequest);
    }

    @PostMapping("/shipment")
    public void registerShipment (@RequestBody ShipmentRegistrationRequest shipmentRegistrationRequest) {
        log.info("new shipment registration {}", shipmentRegistrationRequest);
        shipmentService.registerShipment(shipmentRegistrationRequest);
    }

    @PostMapping("/order_item")
    public void registerOrderItem (@RequestBody OrderItemRegistrationRequest orderItemRegistrationRequest) {
        log.info("new order item registration {}", orderItemRegistrationRequest);
        orderItemService.registerOrderItem(orderItemRegistrationRequest);
    }

    @GetMapping
    public List<Order> getOrder () { return orderService.getOrder(); }

    @GetMapping("/shipment")
    public List<Shipment> getShipment () { return shipmentService.getShipment(); }

    @GetMapping("/order_item")
    public List<OrderItem> getOrderItem () { return orderItemService.getOrderItem(); }
}
