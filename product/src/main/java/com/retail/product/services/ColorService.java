package com.retail.product.services;

import com.retail.product.entities.Color;
import com.retail.product.repositories.ColorRepository;
import com.retail.product.requests.ColorRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;

    public void registerColor (ColorRegistrationRequest request) {
        Color color = Color.builder()
                .name(request.name())
                .build();

        colorRepository.saveAndFlush(color);
    }

    public List<Color> getColor () { return this.colorRepository.findAll(); }

}
