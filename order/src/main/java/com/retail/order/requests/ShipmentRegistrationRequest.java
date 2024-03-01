package com.retail.order.requests;

public record ShipmentRegistrationRequest(
        String date,
        Long orderId
) {
}
