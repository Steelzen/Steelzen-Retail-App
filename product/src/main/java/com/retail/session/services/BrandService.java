package com.retail.session.services;

import com.retail.session.entities.Brand;
import com.retail.session.repositories.BrandRepository;
import com.retail.session.requests.BrandRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Brand> getBrand () { return this.brandRepository.findAll(); }
}
