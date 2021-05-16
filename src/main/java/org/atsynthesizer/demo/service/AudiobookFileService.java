package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.AudiobookFile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


public interface AudiobookFileService {

    public Iterable<AudiobookFile> allAudiobookFiles();

    public AudiobookFile getById(Long id);

    public String getFileSize(File file);
    public String saveUploadedFile(MultipartFile file, UserDetails currentUser);
/*
    public void add(Audiobook audiobook);

    boolean checkByPassport(Audiobook audiobook);

    boolean checkByIdentifyNumber(Audiobook audiobook);

    public void delete(Audiobook audiobook);


    public void edit(Audiobook audiobook);

*/

}
