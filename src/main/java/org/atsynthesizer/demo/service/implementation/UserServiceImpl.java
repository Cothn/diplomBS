package org.atsynthesizer.demo.service.implementation;


import lombok.var;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.Role;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.repository.UserRepository;
import org.atsynthesizer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getById(Long id) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    @Transactional
    public boolean edit(User user) {
        Optional<User> userFromDB = userRepository.findByNickname(user.getUsername());
        if (userFromDB.isPresent() ) {
            if (userFromDB.get().getId() == user.getId()){
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                user.setRole(userFromDB.get().getRole());
                userRepository.save(user);
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean add(User user) {
        Optional<User> userFromDB = userRepository.findByNickname(user.getUsername());
        if (userFromDB.isPresent()) {
            return false;
        }

        user.setRole(new Role(1L, "ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByNickname(s);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    public User getByNickname(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByNickname(s);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }
}
