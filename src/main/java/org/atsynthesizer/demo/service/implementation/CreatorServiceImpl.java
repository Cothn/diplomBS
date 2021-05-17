package org.atsynthesizer.demo.service.implementation;


import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Genre;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.repository.CreatorRepository;
import org.atsynthesizer.demo.repository.GenreRepository;
import org.atsynthesizer.demo.service.CreatorService;
import org.atsynthesizer.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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



        @Override
        @Transactional
        public Creator add(Creator creator) {
            Optional<Creator> creatorFromDB = creatorRepository.findByAuthorAndTitle(creator.isAuthor(), creator.getTitle());
            return creatorFromDB.orElseGet(() ->
                    creatorRepository.save(creator));
        }
    /*
        @Override
        @Transactional
        public boolean checkByPassport(Creator creator) {
            List<Creator> creators = creatorRepository.allCreators();
            for (Creator cl : creators){
                if(cl.getPassportSeries().equalsIgnoreCase(creator.getPassportSeries()) &&
                        cl.getPassportNumber().equalsIgnoreCase(creator.getPassportNumber()) &&
                                (cl.getId() != creator.getId()))
                    return true;
            }
            return false;
        }

        @Override
        @Transactional
        public boolean checkByIdentifyNumber(Creator creator) {
            List<Creator> creators = creatorRepository.allCreators();
            for (Creator cl : creators){
                if(cl.getIdentificationNumber().equalsIgnoreCase(creator.getIdentificationNumber()) &&
                    (cl.getId() != creator.getId()))
                    return true;
            }
            return false;
        }

        @Override
        @Transactional
        public void delete(Creator creator) {
            creatorRepository.delete(creator);
        }

        @Override
        @Transactional
        public void edit(Creator creator) {
            creatorRepository.edit(creator);
        }
    */

}
