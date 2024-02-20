package com.retail.product.services;

import com.retail.product.entities.ProductImage;
import com.retail.product.entities.ProductVariant;
import com.retail.product.repositories.ProductImageRepository;
import com.retail.product.repositories.ProductVariantRepository;
import com.retail.product.requests.ProductImageRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductImageService {
    private final ProductImageRepository productImageRepository;
    private final ProductVariantRepository productVariantRepository;

    public void registerProductImage (ProductImageRegistrationRequest request) {
        ProductVariant productVariant = productVariantRepository.findById(request.productVariantId())
                .orElseThrow(() -> new RuntimeException("Product variant not found"));

        ProductImage productImage = ProductImage.builder()
                .productVariant(productVariant)
                .imgURL(request.imgURL())
                .build();

        productImageRepository.saveAndFlush(productImage);
    }

    public List<ProductImage> getProductImage () { return this.productImageRepository.findAll(); }
}
