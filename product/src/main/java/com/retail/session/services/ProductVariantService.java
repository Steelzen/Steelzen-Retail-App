package com.retail.session.services;

import com.retail.session.entities.Color;
import com.retail.session.entities.Product;
import com.retail.session.entities.ProductVariant;
import com.retail.session.entities.Size;
import com.retail.session.repositories.ColorRepository;
import com.retail.session.repositories.ProductRepository;
import com.retail.session.repositories.ProductVariantRepository;
import com.retail.session.repositories.SizeRepository;
import com.retail.session.requests.ProductVariantRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<ProductVariant> getProductVariant () { return this.productVariantRepository.findAll(); }

    public Optional<ProductVariant> getProductVariantById (Long productVariantId) {
        return this.productVariantRepository.findById(productVariantId);
    }
}
