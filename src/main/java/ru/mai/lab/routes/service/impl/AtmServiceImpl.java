package ru.mai.lab.routes.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.lab.routes.entity.Atm;
import ru.mai.lab.routes.repository.AtmRepository;
import ru.mai.lab.routes.service.AtmService;

import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class AtmServiceImpl implements AtmService {

    private final AtmRepository repository;

    public AtmServiceImpl(AtmRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(Collection<Atm> atms) {
        repository.saveAll(atms);
    }

    @Override
    public List<Atm> getAll() {
        return repository.findAll();
    }

}
