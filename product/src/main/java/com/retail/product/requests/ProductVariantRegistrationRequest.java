package com.retail.product.requests;

import com.retail.product.entities.Color;
import com.retail.product.entities.Product;
import com.retail.product.entities.Size;

public record ProductVariantRegistrationRequest(
        Product product,
        Color color,
        Size size,
        Double price,
        Integer stock
) {
}
