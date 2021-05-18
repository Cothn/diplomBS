package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.Comment;
import org.atsynthesizer.demo.entity.Query;
import org.atsynthesizer.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface QueryService {

    public Page<Query> allQuery(Pageable page);

    public void add( Query query);

    public void delete( Query query);

    public Query getById(Long id);

    public Optional<Query> getByUserAndAudiobook(User user, Audiobook audiobook);

/*


    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
