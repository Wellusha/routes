package ru.mai.lab.routes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer day;

    @OneToOne
    private Collector collector;

    @OneToOne
    @JoinColumn(name = "atm_from")
    private Atm atmFrom;

    @OneToOne
    @JoinColumn(name = "atm_to")
    private Atm atmTo;
}
