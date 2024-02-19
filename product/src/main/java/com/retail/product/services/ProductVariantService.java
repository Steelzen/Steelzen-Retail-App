package com.retail.product.services;

import com.retail.product.entities.Color;
import com.retail.product.entities.Product;
import com.retail.product.entities.ProductVariant;
import com.retail.product.entities.Size;
import com.retail.product.repositories.ColorRepository;
import com.retail.product.repositories.ProductRepository;
import com.retail.product.repositories.ProductVariantRepository;
import com.retail.product.repositories.SizeRepository;
import com.retail.product.requests.ProductVariantRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductVariantService {
    private final ProductVariantRepository productVariantRepository;
    private final ProductRepository productRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;

    public void registerProductVariant (ProductVariantRegistrationRequest request) {
        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Color color = colorRepository.findById(request.colorId())
                .orElseThrow(() -> new RuntimeException("Color not found"));
        Size size = sizeRepository.findById(request.sizeId())
                .orElseThrow(() -> new RuntimeException("Size not Found"));

        ProductVariant productVariant = ProductVariant.builder()
                .product(product)
                .color(color)
                .size(size)
                .price(request.price())
                .stock(request.stock())
                .build();

        productVariantRepository.saveAndFlush(productVariant);
    }
}
