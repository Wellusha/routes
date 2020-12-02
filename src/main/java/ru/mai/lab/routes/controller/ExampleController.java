package ru.mai.lab.routes.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mai.lab.routes.entity.Route;
import ru.mai.lab.routes.service.RouteService;

import java.util.List;

@Controller
@AllArgsConstructor
public class ExampleController {
    private final RouteService routeService;

    @GetMapping("/example")
    public String example(@RequestParam String exampleString, Model model) {
        model.addAttribute("exampleString", exampleString);
        return "example";
    }

    @GetMapping("/routes/get")
    public String getRoutes(@RequestParam(required = false) Integer day, Model model) {
        List<Route> routes = routeService.getRoutes(day);
        // возможно, нужно будет использовать как-то по-другому
        model.addAttribute("routes", routes);
        // здесь вместо null должно быть имя страницы на thymeleaf
        return null;
    }
}
