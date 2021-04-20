package com.example.demo.converter;

import com.example.demo.entity.Nationality;
import com.example.demo.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NationalityConverter implements Converter<String, Nationality> {

    private final NationalityService nationalityService;

    @Autowired
    public NationalityConverter(NationalityService nationalityService) {
        this.nationalityService = nationalityService;
    }

    @Override
        public Nationality convert(String id) {
            System.out.println("Trying to convert id=" + id + " into a nationality");

            int parsedId = Integer.parseInt(id);

            return nationalityService.getById(parsedId);
        }
}

