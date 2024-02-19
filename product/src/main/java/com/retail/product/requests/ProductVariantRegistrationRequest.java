package com.retail.product.requests;

import com.retail.product.entities.Color;
import com.retail.product.entities.Product;
import com.retail.product.entities.Size;

public record ProductVariantRegistrationRequest(
        Long productId,
        Long colorId,
        Long sizeId,
        Double price,
        Integer stock
) {
}
