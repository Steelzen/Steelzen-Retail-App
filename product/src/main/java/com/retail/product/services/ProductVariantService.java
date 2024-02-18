package com.retail.product.services;

import com.retail.product.entities.ProductVariant;
import com.retail.product.repositories.ProductVariantRepository;
import com.retail.product.requests.ProductVariantRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductVariantService {
    private final ProductVariantRepository productVariantRepository;

    public void registerProductVariant (ProductVariantRegistrationRequest request) {
        ProductVariant productVariant = ProductVariant.builder()
                .product(request.product())
                .color(request.color())
                .size(request.size())
                .price(request.price())
                .stock(request.stock())
                .build();

        productVariantRepository.saveAndFlush(productVariant);
    }
}
