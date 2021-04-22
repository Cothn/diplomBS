package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface GenreService {

    public Iterable<Genre> allGenres();

    public Genre getById(Long id);
/*
    public void add(Audiobook audiobook);

    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
