package ru.mai.lab.routes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.lab.routes.entity.Collector;
import ru.mai.lab.routes.repository.CollectorRepository;
import ru.mai.lab.routes.service.CollectorService;

import java.util.Collection;

@Transactional
@Service
public class CollectorServiceImpl implements CollectorService {

    private final CollectorRepository repository;

    @Autowired
    public CollectorServiceImpl(CollectorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(Collection<Collector> collectors) {
        repository.saveAll(collectors);
    }

}
