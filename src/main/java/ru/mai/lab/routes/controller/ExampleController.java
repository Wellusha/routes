package ru.mai.lab.routes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mai.lab.routes.entity.Atm;

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
    public String collectors() {
        return "Collectors";
    }

    @GetMapping("/paths")
    public String paths() {
        return "Paths";
    }
}
