package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends CrudRepository<Creator, Long>, PagingAndSortingRepository<Creator, Long> {

}
