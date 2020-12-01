package ru.mai.lab.routes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleController {

    @GetMapping("/example")
    public String example(@RequestParam String exampleString, Model model) {
        model.addAttribute("exampleString", exampleString);
        return "example";
    }

    @GetMapping("/atms")
    public String atms() {
        return "ATMs";
    }

    @GetMapping("/collectors")
    public String collectors() {
        return "Collectors";
    }

    @GetMapping("/paths")
    public String paths() {
        return "Paths";
    }
}
