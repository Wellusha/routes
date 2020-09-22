package ru.mai.lab.routes.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collectors")
public class Collector {
    @Id
    private Integer id;
}
