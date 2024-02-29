package com.retail.order.requests;

public record OrderRegistrationRequest(
        String date,
        Long customerId
) {
}
