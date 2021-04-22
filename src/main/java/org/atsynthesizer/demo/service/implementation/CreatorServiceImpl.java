package org.atsynthesizer.demo.service.implementation;


import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.atsynthesizer.demo.repository.CreatorRepository;
import org.atsynthesizer.demo.repository.GenreRepository;
import org.atsynthesizer.demo.service.CreatorService;
import org.atsynthesizer.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class CreatorServiceImpl implements CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    @Override
    @Transactional
    public Iterable<Creator> allCreators() {
        return creatorRepository.findAll();
    }

    @Override
    @Transactional
    public Creator getById(Long id) {
        return creatorRepository.findById(id).get();
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
