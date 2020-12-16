package ru.mai.lab.routes.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mai.lab.routes.entity.Collector;
import ru.mai.lab.routes.entity.Route;
import ru.mai.lab.routes.repository.AtmRepository;
import ru.mai.lab.routes.repository.CollectorRepository;
import ru.mai.lab.routes.repository.RouteRepository;
import ru.mai.lab.routes.service.RouteService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final AtmRepository atmRepository;
    private final CollectorRepository collectorRepository;

    @Override
    public List<Route> getRoutes(Integer day) {
        if (day != null) {
            return routeRepository.findAllByDay(day);
        } else return routeRepository.findAll();
    }

    @Override
    public void calculateRoutes(Integer forDays) {
        List<Collector> collectors = collectorRepository.findAll();
        for (int day = 1; day < forDays; day++) {
            // Тут должен быть расчет маршрута на каждый day
            // Пока только заглушка
            for (Collector collector : collectors) {
                Route route = new Route();
                route.setAtmFrom(atmRepository.findAll().stream().collect(toShuffledList()).get(0));
                route.setAtmTo(atmRepository.findAll().stream().collect(toShuffledList()).get(0));
                route.setCollector(collector);
                route.setDay(day);
                routeRepository.save(route);
            }
        }
    }

    // для заглушки
    @SuppressWarnings("unchecked")
    private static <T> java.util.stream.Collector<T, ?, List<T>> toShuffledList() {
        java.util.stream.Collector<?, ?, ?> SHUFFLER = Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new),
                list -> {
                    Collections.shuffle(list);
                    return list;
                });
        return (java.util.stream.Collector<T, ?, List<T>>) SHUFFLER;
    }
}
