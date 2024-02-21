package com.retail.session.requests;

public record ProductImageRegistrationRequest(
        Long productVariantId,
        String imgURL
) {
}
