package ru.mai.lab.routes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mai.lab.routes.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
