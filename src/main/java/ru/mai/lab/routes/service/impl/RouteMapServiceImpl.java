package ru.mai.lab.routes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.lab.routes.entity.Atm;
import ru.mai.lab.routes.entity.RouteMap;
import ru.mai.lab.routes.repository.RouteMapRepository;
import ru.mai.lab.routes.service.AtmService;
import ru.mai.lab.routes.service.RouteMapService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class RouteMapServiceImpl implements RouteMapService {

    private final RouteMapRepository repository;
    private final AtmService atmService;

    @Autowired
    public RouteMapServiceImpl(RouteMapRepository repository, AtmService atmService) {
        this.repository = repository;
        this.atmService = atmService;
    }

    @Override
    public void saveAll(Collection<RouteMap> routeMaps) {
        List<Atm> atms = new ArrayList<>();
        for (RouteMap routeMap : routeMaps) {
            atms.add(routeMap.getAtmOne());
            atms.add(routeMap.getAtmTwo());
        }

        atmService.saveAll(atms);
        repository.saveAll(routeMaps);
    }

    @Override
    public List<RouteMap> getAll() {
        return repository.findAll();
    }

}
