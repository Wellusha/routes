package ru.mai.lab.routes.service;

import ru.mai.lab.routes.entity.Atm;

import java.util.Collection;
import java.util.Collections;

public interface AtmService {

    default void save(Atm atm) {
        saveAll(Collections.singletonList(atm));
    }

    void saveAll(Collection<Atm> atms);

}