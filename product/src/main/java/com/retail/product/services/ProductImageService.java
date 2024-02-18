package com.retail.product.services;

import com.retail.product.entities.ProductImage;
import com.retail.product.repositories.ProductImageRepository;
import com.retail.product.requests.ProductImageRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductImageService {
    private  final ProductImageRepository productImageRepository;

    public void registerProductImage (ProductImageRegistrationRequest request) {
        ProductImage productImage = ProductImage.builder()
                .productVariant(request.productVariant())
                .imgURL(request.imgURL())
                .build();

        productImageRepository.saveAndFlush(productImage);
    }
}
