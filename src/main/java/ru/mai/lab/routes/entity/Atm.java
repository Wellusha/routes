package ru.mai.lab.routes.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atms")
@Data
public class Atm {
    @Id
    private Integer id;

    private Integer in;

    private Integer out;

    private Double expected;

    private Double dispersion;
}
