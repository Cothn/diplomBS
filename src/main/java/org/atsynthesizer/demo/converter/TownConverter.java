package com.example.demo.converter;

import com.example.demo.entity.Town;
import com.example.demo.service.ClientService;
import com.example.demo.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TownConverter implements Converter<String, Town> {

    private final TownService townService;

    @Autowired
    public TownConverter(TownService townService) {
        this.townService = townService;
    }

    @Override
        public Town convert(String id) {
            System.out.println("Trying to convert id=" + id + " into a town");

            int parsedId = Integer.parseInt(id);

            return townService.getById(parsedId);
        }
}

