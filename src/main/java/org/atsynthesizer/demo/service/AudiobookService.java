package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Audiobook;

import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.atsynthesizer.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface AudiobookService {

    public Page<Audiobook> allAudiobooks(Pageable page);

    public Page<Audiobook> getAudiobooksByTitle(String title, Pageable page);

    public Page<Audiobook> getAudiobooksByGenre(Genre genre, Pageable page);

    public Page<Audiobook> getAudiobooksByCreator(Creator creator, Pageable page);

    public Page<Audiobook> getAudiobooksByYear(Long year, Pageable page);

    public Page<Audiobook> allAudiobooks(User user, Pageable page);

    public Page<Audiobook> getAudiobooksByTitle(User user, String title, Pageable page);

    public Page<Audiobook> getAudiobooksByGenre(User user, Genre genre, Pageable page);

    public Page<Audiobook> getAudiobooksByCreator(User user, Creator creator, Pageable page);

    public Page<Audiobook> getAudiobooksByYear(User user, Long year, Pageable page);

    public Audiobook getById(Long id);

    public void edit(Audiobook audiobook);

    public Audiobook getFirst();

    public void add(Audiobook audiobook);

    public void delete(Audiobook audiobook);


}
