package com.retail.product.requests;

import com.retail.product.entities.Brand;
import com.retail.product.entities.Category;

public record ProductRegistrationRequest(
        String name,
        String detail,
        Brand brand,
        Category category
) {
}
