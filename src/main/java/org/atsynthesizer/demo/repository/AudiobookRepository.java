package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.atsynthesizer.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AudiobookRepository extends CrudRepository<Audiobook, Long>, PagingAndSortingRepository<Audiobook, Long> {
    Optional<Audiobook> findFirstByOrderByAddDate();
    Page<Audiobook> findAllByDistributedIsTrue( Pageable var1);
    Page<Audiobook> findAllByTitleContainsAndDistributedIsTrue(String title, Pageable var1);
    Page<Audiobook> findAllByAudiobookGenresContainsAndDistributedIsTrue(Genre genre, Pageable var1);
    Page<Audiobook> findAllByAudiobookCreatorsContainsAndDistributedIsTrue(Creator creator, Pageable var1);
    Page<Audiobook> findAllByPublicationYearEqualsAndDistributedIsTrue(int year, Pageable var1);
    Page<Audiobook> findAllByUserAndDistributedIsFalse(User user, Pageable var1);
    Page<Audiobook> findAllByTitleContainsAndUserAndDistributedIsFalse(String title, User user, Pageable var1);
    Page<Audiobook> findAllByAudiobookGenresContainsAndUserAndDistributedIsFalse(Genre genre, User user, Pageable var1);
    Page<Audiobook> findAllByAudiobookCreatorsContainsAndUserAndDistributedIsFalse(Creator creator, User user, Pageable var1);
    Page<Audiobook> findAllByPublicationYearEqualsAndUserAndDistributedIsFalse(int year, User user, Pageable var1);
}
