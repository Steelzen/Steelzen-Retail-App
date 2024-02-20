package com.retail.product.services;

import com.retail.product.entities.Brand;
import com.retail.product.entities.Category;
import com.retail.product.entities.Product;
import com.retail.product.repositories.BrandRepository;
import com.retail.product.repositories.CategoryRepository;
import com.retail.product.repositories.ProductRepository;
import com.retail.product.requests.ProductRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public void registerProduct (ProductRegistrationRequest request) {
        Brand brand = brandRepository.findById(request.brandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = Product.builder()
                .name(request.name())
                .detail(request.detail())
                .brand(brand)
                .category(category)
                .build();

        productRepository.saveAndFlush(product);
    }

    public List<Product> getProduct () { return this.productRepository.findAll(); }
}
