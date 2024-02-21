package com.retail.session.services;

import com.retail.session.entities.Category;
import com.retail.session.repositories.CategoryRepository;
import com.retail.session.requests.CategoryRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Category> getCategory () {
        return this.categoryRepository.findAll();
    }
}
