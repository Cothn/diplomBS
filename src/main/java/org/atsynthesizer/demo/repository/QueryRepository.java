package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueryRepository extends CrudRepository<Query, Long>, PagingAndSortingRepository<Query, Long> {
    Page<Query> findAll(Pageable var1);
    Optional<Query> findByUserAndAudiobook(User user, Audiobook audiobook);
    /*
        Page<Audiobook> findAllByTitleContainsAndDistributedIsTrue(String title, Pageable var1);
        Page<Audiobook> findAllByAudiobookGenresContainsAndDistributedIsTrue(Genre genre, Pageable var1);
        Page<Audiobook> findAllByAudiobookCreatorsContainsAndDistributedIsTrue(Creator creator, Pageable var1);
        Page<Audiobook> findAllByPublicationYearEqualsAndDistributedIsTrue(int year, Pageable var1);
        Page<Audiobook> findAllByUserAndDistributedIsFalse(User user, Pageable var1);
        Page<Audiobook> findAllByTitleContainsAndUserAndDistributedIsFalse(String title, User user, Pageable var1);
        Page<Audiobook> findAllByAudiobookGenresContainsAndUserAndDistributedIsFalse(Genre genre, User user, Pageable var1);
        Page<Audiobook> findAllByAudiobookCreatorsContainsAndUserAndDistributedIsFalse(Creator creator, User user, Pageable var1);
        Page<Audiobook> findAllByPublicationYearEqualsAndUserAndDistributedIsFalse(int year, User user, Pageable var1);
    */
}

