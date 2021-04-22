package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.AudiobookFile;
import org.atsynthesizer.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {

}
