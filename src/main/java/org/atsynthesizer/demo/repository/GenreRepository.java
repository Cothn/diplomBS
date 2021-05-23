package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>, PagingAndSortingRepository<Genre, Long> {
 ArrayList<Genre> findAllByIdIsNotNullOrderByTitle();
}
