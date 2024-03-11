package com.retail.customer.requests;

public record ReviewRegistrationRequest(
        Integer grade,
        String detail,
        String imgURL,
        Long productId,
        Long customerId
) {
}
