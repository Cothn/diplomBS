package org.atsynthesizer.demo.service;


import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.User;


public interface UserService {

    public Iterable<User> allUsers();

    public User getById(Long id);

    public User getByNickname(String nickname);

    public boolean add(User user);

    public boolean edit(User user);

}
