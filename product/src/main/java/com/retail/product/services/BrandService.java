package com.retail.product.services;

import com.retail.product.entities.Brand;
import com.retail.product.repositories.BrandRepository;
import com.retail.product.requests.BrandRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public void registerBrand (BrandRegistrationRequest request) {
        Brand brand = Brand.builder()
                .name(request.name())
                .build();

        brandRepository.saveAndFlush(brand);
    }
}
