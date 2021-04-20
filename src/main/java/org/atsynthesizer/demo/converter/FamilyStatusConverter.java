package com.example.demo.converter;

import com.example.demo.entity.FamilyStatus;
import com.example.demo.service.FamilyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FamilyStatusConverter implements Converter<String, FamilyStatus> {

    private final FamilyStatusService familyStatusService;

    @Autowired
    public FamilyStatusConverter(FamilyStatusService familyStatusService) {
        this.familyStatusService = familyStatusService;
    }

    @Override
        public FamilyStatus convert(String id) {
            System.out.println("Trying to convert id=" + id + " into a familyStatus");

            int parsedId = Integer.parseInt(id);

            return familyStatusService.getById(parsedId);
        }
}

