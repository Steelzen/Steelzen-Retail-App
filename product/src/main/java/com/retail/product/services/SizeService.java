package com.retail.product.services;

import com.retail.product.entities.Size;
import com.retail.product.repositories.SizeRepository;
import com.retail.product.requests.SizeRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SizeService {
    private final SizeRepository sizeRepository;

    public void registerSize (SizeRegistrationRequest request) {
        Size size =Size.builder()
                .name(request.name())
                .build();

        sizeRepository.saveAndFlush(size);
    }
}
