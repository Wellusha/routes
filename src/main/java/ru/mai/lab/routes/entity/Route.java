package ru.mai.lab.routes.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@Data
public class Route {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "day")
    private Integer day;

    @OneToOne
    @JoinColumn(name = "collector")
    private Collector collector;

    @OneToOne
    @JoinColumn(name = "atm_from")
    private Atm atmFrom;

    @OneToOne
    @JoinColumn(name = "atm_to")
    private Atm atmTo;

}
