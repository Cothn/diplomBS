package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.AudiobookFile;


public interface AudiobookFileService {

    public Iterable<AudiobookFile> allAudiobookFiles();

    public AudiobookFile getById(Long id);
/*
    public void add(Audiobook audiobook);

    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
