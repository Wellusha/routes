package ru.mai.lab.routes.service;

import ru.mai.lab.routes.entity.Route;

import java.util.List;

public interface RouteService {
    List<Route> getRoutes(Integer day);
    void calculateRoutes(Integer forDays);
}
