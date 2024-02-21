package com.retail.session.services;

import com.retail.session.entities.Brand;
import com.retail.session.entities.Category;
import com.retail.session.entities.Product;
import com.retail.session.repositories.BrandRepository;
import com.retail.session.repositories.CategoryRepository;
import com.retail.session.repositories.ProductRepository;
import com.retail.session.requests.ProductRegistrationRequest;
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
