package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.AudiobookFile;
import org.atsynthesizer.demo.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudiobookFileRepository extends CrudRepository<AudiobookFile, Long>, PagingAndSortingRepository<AudiobookFile, Long> {

}
