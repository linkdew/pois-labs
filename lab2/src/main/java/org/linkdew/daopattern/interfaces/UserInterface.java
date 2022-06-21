package org.linkdew.daopattern.interfaces;

import org.linkdew.daopattern.entities.User;

import java.util.List;

public interface UserInterface {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void create(User user);
    void update(Long id, String new_username);
    void delete(Long id);
}

