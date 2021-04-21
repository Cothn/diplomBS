package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Audiobook;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface AudiobookService {

    public Page<Audiobook> allAudiobooks(Pageable page);


    public Audiobook getById(Long id);
/*
    public void add(Audiobook audiobook);

    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
