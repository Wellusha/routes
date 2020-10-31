package ru.mai.lab.routes.service.impl;

import org.springframework.stereotype.Service;
import ru.mai.lab.routes.entity.Collector;

@Service
public class CollectorGeneratorService extends BaseGeneratorService<Collector> {

    @Override
    public Collector generate() {
        return new Collector();
    }

}
