package com.retail.session.services;

import com.retail.session.entities.Color;
import com.retail.session.repositories.ColorRepository;
import com.retail.session.requests.ColorRegistrationRequest;
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
