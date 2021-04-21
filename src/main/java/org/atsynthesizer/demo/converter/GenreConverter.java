package org.atsynthesizer.demo.converter;

import com.example.demo.service.DisabilityService;
import org.atsynthesizer.demo.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter implements Converter<String, Genre> {

    private final DisabilityService disabilityService;

    @Autowired
    public GenreConverter(DisabilityService disabilityService) {
        this.disabilityService = disabilityService;
    }

    @Override
        public Disability convert(String id) {
            System.out.println("Trying to convert id=" + id + " into a disability");

            int parsedId = Integer.parseInt(id);

            return disabilityService.getById(parsedId);
        }
}

