package ru.mai.lab.routes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route_maps")
public class RouteMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "atm_one")
    private Atm atmOne;

    @OneToOne
    @JoinColumn(name = "atm_two")
    private Atm atmTwo;

    @Column(name = "distance_between")
    private Integer distance;
}
