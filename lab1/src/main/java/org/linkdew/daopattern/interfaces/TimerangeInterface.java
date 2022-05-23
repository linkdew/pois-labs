package org.linkdew.daopattern.interfaces;

import org.linkdew.daopattern.entities.Timerange;

import java.util.List;

public interface TimerangeInterface {
    Timerange findById(Long id);
    Timerange findByTaskId(Long id);
    List<Timerange> findAll();
    void create(Timerange timerange);
    void update(Long id, String note); // seconds?
    void delete(Long id);
}
