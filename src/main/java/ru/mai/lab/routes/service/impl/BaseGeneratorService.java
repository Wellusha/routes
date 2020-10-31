package ru.mai.lab.routes.service.impl;

import ru.mai.lab.routes.service.GeneratorService;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGeneratorService<T> implements GeneratorService<T> {

    private static final int MIN_COUNT = 1;

    @Override
    public List<T> generate(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("Illegal count value " + count + ". It must have positive value!");
        }

        List<T> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(generate());
        }

        return list;
    }

}
