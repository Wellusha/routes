package ru.mai.lab.routes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mai.lab.routes.entity.Atm;
import ru.mai.lab.routes.entity.Collector;
import ru.mai.lab.routes.entity.Route;
import ru.mai.lab.routes.entity.RouteMap;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ExampleController {

    @GetMapping("/example")
    public String example(@RequestParam String exampleString, Model model) {
        model.addAttribute("exampleString", exampleString);
        return "example";
    }

    @GetMapping("/atms")
    public String atms(Model model) {
        List<Atm> atms = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Atm atm = new Atm();
            atm.setId(i);
            atm.setDispersion((double) i);
            atm.setExpected((double) i);
            atm.setIn(i);
            atm.setOut(i);
            atms.add(atm);
        }
        model.addAttribute("atms", atms);
        return "ATMs";
    }

    @GetMapping("/collectors")
    public String collectors(Model  model) {
        List<Collector> collectors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Collector collector = new Collector();
            collector.setId(i);

            collectors.add(collector);
        }
        model.addAttribute("collectors", collectors);
        return "Collectors";
    }

    @GetMapping("/paths")
    public String paths(Model model) {
        List<Route> routes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Collector col = new Collector();
            col.setId(i);

            Atm a = new Atm();
            a.setId(i);
            a.setDispersion((double) i);
            a.setExpected((double) i);
            a.setIn(i);
            a.setOut(i);

            Route route = new Route();
            route.setId(i);
            route.setDay(i);
            route.setCollector(col);
            route.setAtmFrom(a);
            route.setAtmTo(a);

            routes.add(route);
        }
        model.addAttribute("routes", routes);
        return "Paths";
    }

    @GetMapping("/maps")
    public String maps(Model model) {
        List<RouteMap> routemaps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Atm a = new Atm();
            a.setId(i);
            a.setDispersion((double) i);
            a.setExpected((double) i);
            a.setIn(i);
            a.setOut(i);

            RouteMap routemap = new RouteMap();
            routemap.setId(i);
            routemap.setAtmOne(a);
            routemap.setAtmTwo(a);
            routemap.setDistance(i);
            routemap.setExpected((double)i);
            routemap.setDispersion((double)i);


            routemaps.add(routemap);
        }
        model.addAttribute("routemaps", routemaps);
        return "RouteMaps";
    }
}
