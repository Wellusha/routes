package ru.mai.lab.routes.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mai.lab.routes.entity.Atm;
import ru.mai.lab.routes.entity.Collector;
import ru.mai.lab.routes.entity.Route;
import ru.mai.lab.routes.entity.RouteMap;
import ru.mai.lab.routes.service.RouteService;
import ru.mai.lab.routes.service.AtmService;
import ru.mai.lab.routes.service.CollectorService;
import ru.mai.lab.routes.service.RouteMapService;


import java.util.ArrayList;
import java.util.List;


@Controller
@AllArgsConstructor
public class ExampleController {
    private final AtmService atmService;
    private final CollectorService collectorService;
    private final RouteMapService routeMapService;
    private final RouteService routeService;

    @GetMapping("/atms")
    public String atms(Model model) {
        List<Atm> atms = atmService.getAll();
        model.addAttribute("atms", atms);
        return "ATMs";
    }

    @GetMapping("/collectors")
    public String collectors(Model model) {
        List<Collector> collectors = collectorService.getAll();
        model.addAttribute("collectors", collectors);
        return "Collectors";
    }

    @GetMapping("/paths")
    public String paths(Model model) {
        List<Route> routes = routeService.getRoutes(null);
        model.addAttribute("routes", routes);
        return "Paths";
    }

    @GetMapping("/maps")
    public String maps(Model model) {
        List<RouteMap> routemaps = routeMapService.getAll();
        model.addAttribute("routemaps", routemaps);
        return "RouteMaps";
    }
}
