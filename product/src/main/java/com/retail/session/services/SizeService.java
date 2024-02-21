package com.retail.session.services;

import com.retail.session.entities.Size;
import com.retail.session.repositories.SizeRepository;
import com.retail.session.requests.SizeRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Size> getSize () { return sizeRepository.findAll(); }
}
