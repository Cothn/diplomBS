package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Creator;


public interface CreatorService {

    public Iterable<Creator> allCreators();

    public Creator getById(Long id);

    public Creator add(Creator creator);
/*
    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
