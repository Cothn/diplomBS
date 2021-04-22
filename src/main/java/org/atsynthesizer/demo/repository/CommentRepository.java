package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>, PagingAndSortingRepository<Comment, Long> {
    Iterable<Comment> findAllByAudiobookId(Long id);
}
