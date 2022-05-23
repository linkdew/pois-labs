package org.linkdew.daopattern.interfaces;

import org.linkdew.daopattern.entities.Task;

import java.util.List;

public interface TaskInterface {
    Task findById(Long id);
    List<Task> findAll();
    List<Task> findByStatus(String status);
    void create(Task task);
    void update(Long id, Integer new_priority);
    void delete(Long id);
}
