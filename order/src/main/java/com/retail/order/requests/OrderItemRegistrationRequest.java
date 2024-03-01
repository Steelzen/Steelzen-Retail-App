package com.retail.order.requests;

public record OrderItemRegistrationRequest(
        Integer quantity,
        Double discount,
        Long productVariantId,
        Long orderId
) {
}
