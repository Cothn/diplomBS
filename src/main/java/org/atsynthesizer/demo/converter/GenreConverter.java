package org.atsynthesizer.demo.converter;

import org.atsynthesizer.demo.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
/*
@Component
public class GenreConverter implements Converter<String, Genre> {

    private final GenreService genreService;

    @Autowired
    public GenreConverter(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
        public Genre convert(String id) {
            System.out.println("Trying to convert id=" + id + " into a genre");

            int parsedId = Integer.parseInt(id);

            return genreService.getById(parsedId);
        }


}
 */
