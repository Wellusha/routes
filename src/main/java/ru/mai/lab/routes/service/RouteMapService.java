package ru.mai.lab.routes.service;

import ru.mai.lab.routes.entity.RouteMap;

import java.util.Collection;
import java.util.Collections;

public interface RouteMapService {

    default void save(RouteMap routeMap) {
        saveAll(Collections.singletonList(routeMap));
    }

    void saveAll(Collection<RouteMap> routeMaps);

}
