package com.retail.product.requests;

public record ProductRegistrationRequest(
        String name,
        String detail,
        Long brandId,
        Integer categoryId
) {
}
