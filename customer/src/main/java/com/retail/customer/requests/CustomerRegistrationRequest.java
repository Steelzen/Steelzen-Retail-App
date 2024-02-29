package com.retail.customer.requests;

public record CustomerRegistrationRequest(
    String email,
    String firstName,
    String lastName,
    String phone
) {
}

