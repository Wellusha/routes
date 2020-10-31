package ru.mai.lab.routes.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "collectors")
@Data
public class Collector {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collector collector = (Collector) o;
        return Objects.equals(id, collector.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
