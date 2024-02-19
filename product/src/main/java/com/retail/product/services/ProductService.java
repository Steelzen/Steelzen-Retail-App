package com.retail.product.services;

import com.retail.product.entities.Product;
import com.retail.product.repositories.ProductRepository;
import com.retail.product.requests.ProductRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void registerProduct (ProductRegistrationRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .detail(request.detail())
                .brand(request.brand())
                .category(request.category())
                .build();

        productRepository.saveAndFlush(product);
    }
}
