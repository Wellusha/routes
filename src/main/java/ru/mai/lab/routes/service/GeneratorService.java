package ru.mai.lab.routes.service;

import java.util.List;

public interface GeneratorService<T> {

    T generate();

    List<T> generate(int count);

}
