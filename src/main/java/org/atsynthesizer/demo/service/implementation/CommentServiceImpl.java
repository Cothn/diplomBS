package org.atsynthesizer.demo.service.implementation;


import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.repository.CommentRepository;
import org.atsynthesizer.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Iterable<Comment> getAllByAudiobook(Audiobook audiobook) {
        return commentRepository.findAllByAudiobook(audiobook);
    }

    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void edit(Comment comment) { commentRepository.save(comment); }

    @Override
    public void delete(Comment comment) { commentRepository.delete(comment); }

}
