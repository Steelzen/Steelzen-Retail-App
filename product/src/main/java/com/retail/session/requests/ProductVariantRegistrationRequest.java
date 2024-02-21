package com.retail.session.requests;

public record ProductVariantRegistrationRequest(
        Long productId,
        Long colorId,
        Long sizeId,
        Double price,
        Integer stock
) {
}
