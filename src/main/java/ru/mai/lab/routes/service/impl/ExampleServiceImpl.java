package ru.mai.lab.routes.service.impl;

import org.springframework.stereotype.Service;
import ru.mai.lab.routes.service.ExampleService;
import ru.mai.lab.routes.service.exception.ExampleException;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public void hello(String name) {
        if (name == null)
            throw new ExampleException();
    }
}
