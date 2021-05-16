package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreatorRepository extends CrudRepository<Creator, Long>, PagingAndSortingRepository<Creator, Long> {
    Optional<Creator> findByAuthorAndTitle(boolean author, String title);
}
