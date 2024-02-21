package com.retail.session.requests;

public record ProductRegistrationRequest(
        String name,
        String detail,
        Long brandId,
        Long categoryId
) {
}
