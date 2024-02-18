package com.retail.product.requests;

import com.retail.product.entities.ProductVariant;
public record ProductImageRegistrationRequest(
        ProductVariant productVariant,
        String imgURL
) {
}
