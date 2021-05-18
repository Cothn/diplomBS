package org.atsynthesizer.demo.service.implementation;

import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Query;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.repository.QueryRepository;
import org.atsynthesizer.demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryRepository queryRepository;

    @Override
    public Page<Query> allQuery(Pageable page) {
        return queryRepository.findAll(page);
    }

    @Override
    @Transactional
    public Query getById(Long id) {
        return queryRepository.findById(id).get();
    }

    public Optional<Query> getByUserAndAudiobook(User user, Audiobook audiobook){
        return  queryRepository.findByUserAndAudiobook(user, audiobook);
    }

    @Override
    public void add(Query query) {
        queryRepository.save(query);
    }

    @Override
    @Transactional
    public void delete(Query query) {

        queryRepository.delete(query);
    }
}
