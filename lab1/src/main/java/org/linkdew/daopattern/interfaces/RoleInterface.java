package org.linkdew.daopattern.interfaces;

import org.linkdew.daopattern.entities.Role;

import java.util.List;

public interface RoleInterface {
    Role findById(Long id);
    List<Role> findAll();
    void create(Role role);
    void update(Long id, String new_role);
    void delete(Long id);
}

