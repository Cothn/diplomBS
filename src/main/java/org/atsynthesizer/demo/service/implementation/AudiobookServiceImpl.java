package org.atsynthesizer.demo.service.implementation;


import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.repository.AudiobookRepository;
import org.atsynthesizer.demo.service.AudiobookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class AudiobookServiceImpl implements AudiobookService {

    @Autowired
    private AudiobookRepository audiobookRepository;

    @Override
    @Transactional
    public Page<Audiobook> allAudiobooks(Pageable page) {
        return audiobookRepository.findAll(page);
    }

    @Override
    @Transactional
    public Audiobook getById(Long id) {
        return audiobookRepository.findById(id).get();
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
