package org.atsynthesizer.demo.service.implementation;


import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.repository.AudiobookRepository;
import org.atsynthesizer.demo.service.AudiobookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AudiobookServiceImpl implements AudiobookService {

    @Autowired
    private AudiobookRepository audiobookRepository;

    @Override
    @Transactional
    public Page<Audiobook> allAudiobooks(Pageable page) {
        return audiobookRepository.findAllByDistributedIsTrue(page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByTitle(String title, Pageable page) {
        return audiobookRepository.findAllByTitleContainsAndDistributedIsTrue(title, page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByGenre(Genre genre, Pageable page) {
        return audiobookRepository.findAllByAudiobookGenresContainsAndDistributedIsTrue(genre, page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByCreator(Creator creator, Pageable page) {
        return audiobookRepository.findAllByAudiobookCreatorsContainsAndDistributedIsTrue(creator,  page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByYear(Long year, Pageable page) {
        return audiobookRepository.findAllByPublicationYearEqualsAndDistributedIsTrue(year.intValue(), page);
    }

    @Override
    @Transactional
    public Page<Audiobook> allAudiobooks(User user, Pageable page) {
        return audiobookRepository.findAllByUserAndDistributedIsFalse(user, page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByTitle(User user, String title, Pageable page) {
        return audiobookRepository.findAllByTitleContainsAndUserAndDistributedIsFalse(title, user, page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByGenre(User user, Genre genre, Pageable page) {
        return audiobookRepository.findAllByAudiobookGenresContainsAndUserAndDistributedIsFalse(genre, user, page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByCreator(User user, Creator creator, Pageable page) {
        return audiobookRepository.findAllByAudiobookCreatorsContainsAndUserAndDistributedIsFalse(creator, user, page);
    }

    @Override
    public Page<Audiobook> getAudiobooksByYear(User user, Long year, Pageable page) {
        return audiobookRepository.findAllByPublicationYearEqualsAndUserAndDistributedIsFalse(year.intValue(), user, page);
    }


    @Override
    @Transactional
    public Audiobook getById(Long id) {
        return audiobookRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void edit(Audiobook audiobook) {
        audiobookRepository.save(audiobook);
    }

    @Override
    public Audiobook getFirst() {
        return audiobookRepository.findFirstByOrderByAddDate().get();
    }

    @Override
    public void add(Audiobook audiobook) {
        audiobookRepository.save(audiobook);
    }

    @Override
    @Transactional
    public void delete(Audiobook audiobook) {
        audiobookRepository.delete(audiobook);
    }
}
