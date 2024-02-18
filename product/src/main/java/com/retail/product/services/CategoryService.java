package com.retail.product.services;

import com.retail.product.entities.Category;
import com.retail.product.repositories.CategoryRepository;
import com.retail.product.requests.CategoryRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void registerCategory (CategoryRegistrationRequest request) {
        Category category = Category.builder()
                .name(request.name())
                .build();

        categoryRepository.saveAndFlush(category);
    }
}
