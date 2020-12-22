package ru.mai.lab.routes.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mai.lab.routes.entity.Atm;
import ru.mai.lab.routes.entity.Collector;
import ru.mai.lab.routes.entity.Route;
import ru.mai.lab.routes.entity.RouteMap;
import ru.mai.lab.routes.repository.AtmRepository;
import ru.mai.lab.routes.repository.CollectorRepository;
import ru.mai.lab.routes.repository.RouteRepository;
import ru.mai.lab.routes.repository.RouteMapRepository;
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
    private final RouteMapRepository routeMapRepository;

    @Override
    public List<Route> getRoutes(Integer day) {
        if (day != null) {
            return routeRepository.findAllByDay(day);
        } else return routeRepository.findAll();
    }

    //функция возвращает время нужное для преодоления расстояния от atmOne до atmTwo
    public double getTime(int atmOne, int atmTwo) {
        if(atmOne == 0 || atmTwo == 0)
            return 1;
        List<RouteMap> routes = routeMapRepository.findAll();
        for(int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getAtmOne().getId() == atmOne)
                if (routes.get(i).getAtmTwo().getId() == atmTwo)
                    return routes.get(i).getExpected();
        }
        return 0;
    }

    @Override
    public void calculateRoutes(Integer forDays) {

        List<Atm> atms = atmRepository.findAll();
        List<Collector> collectors = collectorRepository.findAll();

        Atm atmBufFrom = atms.get(0);
        Atm atmBufTo;
        List<Route> routes = new ArrayList<>();
        int routeId = 1;
        double workshift = 8;

        //Сортировка банкоматов по остальному месту в бункерах, чем меньше места в бункере, тем первее банкоматы стоят в массиве
        for(int i  = 1; i < atms.size(); i++) {
            for (int j = 1; j < atms.size(); j++) {
                if (1000 - atms.get(i).getOut()/atms.get(i).getExpected() + atms.get(i).getIn()/atms.get(i).getExpected()
                        >= 1000 - atms.get(j).getOut()/atms.get(i).getExpected() + atms.get(i).getIn()/atms.get(i).getExpected())
                    Collections.swap(atms, i, j);
            }
        }

        //Создание путей
        for(int i = 0; i < collectors.size(); i++) {
            for (int j = 0; j < (atms.size()-1) / collectors.size(); j++) {
                Route route = new Route();
                route.setId(routeId);                                                   //ставим id
                routeId += 1;                                                           //готовим следующий id
                route.setDay(1);                                                        //устанавливаем день
                route.setCollector(collectors.get(i));                                  //id инкасатора на этом пути
                route.setAtmFrom(atmBufFrom);                                           //ставим от какого atm едет инкасатор
                atmBufTo = atms.get(collectors.get(i).getId() + j * collectors.size()); //вставляем в буфер atm куда поедет
                route.setAtmTo(atmBufTo);                                               //вписываем это в таблицу
                workshift -= getTime(atmBufFrom.getId(), atmBufTo.getId());             //вычитаем время затраченное на поездку из времени рабочего дня
                atmBufFrom = atms.get(collectors.get(i).getId() + j * collectors.size()); //готовим точку начала для следующей итерации
                routes.add(route);

                if (workshift < 0)
                    break;
            }
            atmBufFrom = atms.get(0);   //сбрасываем точку старта для нового инкасатора
            workshift = 8;              //сбрасываем счётчик оставшегося рабочего времени
        }
        //routeRepository.save(routes);
        //Необходимые данные висят в переменной routes

        /*List<Collector> collectors = collectorRepository.findAll();
        List<Atm> atms = atmRepository.findAll();
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
        }*/
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
