package com.retail.session.services;

import com.retail.session.entities.ProductImage;
import com.retail.session.entities.ProductVariant;
import com.retail.session.repositories.ProductImageRepository;
import com.retail.session.repositories.ProductVariantRepository;
import com.retail.session.requests.ProductImageRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<ProductImage> getProductImageByProductVariantId (Long productVariantId) {
        return this.productImageRepository.findProductImageByProductVariantId(productVariantId);
    }
}
