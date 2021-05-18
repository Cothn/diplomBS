package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
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
    Page<Audiobook> findAllByTitleContains(String title, Pageable var1);
    Page<Audiobook> findAllByAudiobookGenresContains(Genre genre, Pageable var1);
    Page<Audiobook> findAllByAudiobookCreatorsContains(Creator creator, Pageable var1);
    Page<Audiobook> findAllByPublicationYearEquals(int year, Pageable var1);
}
