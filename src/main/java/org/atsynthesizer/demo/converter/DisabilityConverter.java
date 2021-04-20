package com.example.demo.converter;

import com.example.demo.entity.Disability;
import com.example.demo.service.DisabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DisabilityConverter implements Converter<String, Disability> {

    private final DisabilityService disabilityService;

    @Autowired
    public DisabilityConverter(DisabilityService disabilityService) {
        this.disabilityService = disabilityService;
    }

    @Override
        public Disability convert(String id) {
            System.out.println("Trying to convert id=" + id + " into a disability");

            int parsedId = Integer.parseInt(id);

            return disabilityService.getById(parsedId);
        }
}

