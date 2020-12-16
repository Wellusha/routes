package ru.mai.lab.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.mai.lab.routes.config.CollectorGeneratorConfig;
import ru.mai.lab.routes.config.RouteMapGeneratorConfig;
import ru.mai.lab.routes.service.CollectorService;
import ru.mai.lab.routes.service.RouteMapService;
import ru.mai.lab.routes.service.RouteService;
import ru.mai.lab.routes.service.impl.CollectorGeneratorService;
import ru.mai.lab.routes.service.impl.RouteMapGeneratorService;

@SpringBootApplication
public class Application {
    @Autowired
    private CollectorGeneratorConfig collectorGeneratorConfig;
    @Autowired
    private RouteMapGeneratorConfig routeMapGeneratorConfig;

    @Autowired
    private CollectorService collectorService;
    @Autowired
    private RouteMapService routeMapService;
    @Autowired
    private RouteService routeService;

    @Autowired
    private CollectorGeneratorService collectorGenerator;
    @Autowired
    private RouteMapGeneratorService routeMapGenerator;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        collectorService.saveAll(collectorGenerator.generate(collectorGeneratorConfig.getCount()));
        routeMapService.saveAll(routeMapGenerator.generate(routeMapGeneratorConfig.getRoutesCount()));
        routeService.calculateRoutes(10);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
