package ru.mai.lab.routes.service;

import ru.mai.lab.routes.entity.Collector;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface CollectorService {

    default void save(Collector collector) {
        saveAll(Collections.singletonList(collector));
    }

    void saveAll(Collection<Collector> collectors);

    List<Collector> getAll();

}
