package ru.mai.lab.routes.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "route_maps")
@Data
public class RouteMap {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "atm_one")
    private Atm atmOne;

    @OneToOne
    @JoinColumn(name = "atm_two")
    private Atm atmTwo;

    @Column(name = "distance")
    private Integer distance;

    @Column(name = "expected")
    private Double expected;

    @Column(name = "dispersion")
    private Double dispersion;

}
