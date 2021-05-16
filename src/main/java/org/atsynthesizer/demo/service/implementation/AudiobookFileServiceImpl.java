package org.atsynthesizer.demo.service.implementation;


import org.apache.commons.lang3.RandomStringUtils;
import org.atsynthesizer.demo.entity.AudiobookFile;
import org.atsynthesizer.demo.repository.AudiobookFileRepository;
import org.atsynthesizer.demo.service.AudiobookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class AudiobookFileServiceImpl implements AudiobookFileService {


    private static String UPLOAD_DIR = "/static/users";

    @Autowired
    private AudiobookFileRepository audiobookFileRepository;

    public String getFileSize(File file) {
        long fileSize = file.length();
        if(fileSize/(1024*1024*1024) > 1) {
            return (double) fileSize / (1024 * 1024 * 1024) + " gb";
        }else if (fileSize/(1024*1024) > 1){
            return (double) file.length()/(1024*1024)+" mb";
        }else if (fileSize/(1024) > 1){
            return (double) file.length()/(1024*1024)+" kb";
        }else{
            return file.length() + " bytes";
        }
    }

    // Save Files
    public String saveUploadedFile(MultipartFile file, UserDetails currentUser) {

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR + "/" +currentUser.getUsername());
        uploadDir.mkdirs();

        if (!file.isEmpty()) {
            try {
                String uploadFilePath = UPLOAD_DIR + "/" +currentUser.getUsername() + "/"
                        + RandomStringUtils.randomAlphanumeric(8)+ "-" + file.getOriginalFilename();

                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadFilePath);
                Files.write(path, bytes);
                return uploadFilePath;
            } catch (Exception e) {
                return "";
            }
        } else {
            return "";
        }

    }

    @Override
    @Transactional
    public Iterable<AudiobookFile> allAudiobookFiles() {
        return audiobookFileRepository.findAll();
    }

    @Override
    @Transactional
    public AudiobookFile getById(Long id) {
        return audiobookFileRepository.findById(id).get();
    }


    /*
        @Override
        @Transactional
        public void add(Audiobook audiobook) {
            audiobookRepository.add(audiobook);
        }

        @Override
        @Transactional
        public boolean checkByPassport(Audiobook audiobook) {
            List<Audiobook> audiobooks = audiobookRepository.allAudiobooks();
            for (Audiobook cl : audiobooks){
                if(cl.getPassportSeries().equalsIgnoreCase(audiobook.getPassportSeries()) &&
                        cl.getPassportNumber().equalsIgnoreCase(audiobook.getPassportNumber()) &&
                                (cl.getId() != audiobook.getId()))
                    return true;
            }
            return false;
        }

        @Override
        @Transactional
        public boolean checkByIdentifyNumber(Audiobook audiobook) {
            List<Audiobook> audiobooks = audiobookRepository.allAudiobooks();
            for (Audiobook cl : audiobooks){
                if(cl.getIdentificationNumber().equalsIgnoreCase(audiobook.getIdentificationNumber()) &&
                    (cl.getId() != audiobook.getId()))
                    return true;
            }
            return false;
        }

        @Override
        @Transactional
        public void delete(Audiobook audiobook) {
            audiobookRepository.delete(audiobook);
        }

        @Override
        @Transactional
        public void edit(Audiobook audiobook) {
            audiobookRepository.edit(audiobook);
        }
    */

}
