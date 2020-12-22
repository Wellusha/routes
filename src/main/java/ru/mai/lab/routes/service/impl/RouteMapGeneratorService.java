package ru.mai.lab.routes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.lab.routes.config.RouteMapGeneratorConfig;
import ru.mai.lab.routes.entity.Atm;
import ru.mai.lab.routes.entity.RouteMap;
import ru.mai.lab.routes.util.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RouteMapGeneratorService extends BaseGeneratorService<RouteMap> {

    private final RouteMapGeneratorConfig config;

    private final List<Atm> atms = new ArrayList<>();
    private final Map<Atm, Boolean> atmsStatuses = new HashMap<>();

    @Autowired
    public RouteMapGeneratorService(RouteMapGeneratorConfig config, AtmGeneratorService atmGenerator) {
        this.config = config;

        initAtms(atmGenerator);
    }

    private void initAtms(AtmGeneratorService atmGenerator) {
        atms.addAll(atmGenerator.generate(config.getAtmCount()));
        for (int i = 0; i < atms.size(); i++){
            Atm atm = atms.get(i);
            atm.setId(i + 1);

            atmsStatuses.put(atm, true);
        }
    }

    @Override
    public List<RouteMap> generate(int count) {
        if (count > atms.size() * atms.size()) throw new IllegalArgumentException("ТЫ ЧТО ДУРАК");

        if (count < atms.size() * atms.size()) {
            return super.generate(count);
        }

        List<RouteMap> list = new ArrayList<>();

        for (Atm atmOne : atms) {
            for (Atm atmTwo : atms) {
                if (atmOne == atmTwo) continue;

                RouteMap map = generate();
                map.setAtmOne(atmOne);
                map.setAtmTwo(atmTwo);

                list.add(map);
            }
        }

        return list;
    }

    @Override
    public RouteMap generate() {
        RouteMap routeMap = new RouteMap();

        routeMap.setAtmOne(pickAtm());
        routeMap.setAtmTwo(pickAtm());
        routeMap.setDistance(RandomUtil.nextInt(config.getMinDistance(), config.getMaxDistance()));
        routeMap.setExpected(RandomUtil.nextDouble(config.getMinExpected(), config.getMaxExpected()));
        routeMap.setDispersion(RandomUtil.nextDouble(config.getMinDispersion(), config.getMaxDispersion()));

        return routeMap;
    }

    private Atm pickAtm() {
        Atm atm = atmsStatuses.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .findAny()
                .orElseGet(() -> atms.get(RandomUtil.nextInt(0, atmsStatuses.size())));

        atmsStatuses.put(atm, false);

        return atm;
    }

}
