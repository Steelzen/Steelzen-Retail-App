package com.retail.order;

import com.retail.order.entiities.Order;
import com.retail.order.requests.OrderRegistrationRequest;
import com.retail.order.services.OrderService;
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
    @PostMapping
    public void registerOrder (@RequestBody OrderRegistrationRequest orderRegistrationRequest) {
        log.info("new order registration {}", orderRegistrationRequest);
        orderService.registerOrder(orderRegistrationRequest);
    }

    @GetMapping
    public List<Order> getOrder () { return orderService.getOrder(); }
}
