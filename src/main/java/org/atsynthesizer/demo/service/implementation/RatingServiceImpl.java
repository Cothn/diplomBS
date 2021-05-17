package org.atsynthesizer.demo.service.implementation;


import org.atsynthesizer.demo.entity.Rating;
import org.atsynthesizer.demo.entity.Role;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.repository.RatingRepository;
import org.atsynthesizer.demo.repository.UserRepository;
import org.atsynthesizer.demo.service.RatingService;
import org.atsynthesizer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public boolean edit(Rating rating) {
        ratingRepository.save(rating);
        return true;
    }


}
