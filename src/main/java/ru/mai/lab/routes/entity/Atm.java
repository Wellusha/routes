package ru.mai.lab.routes.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "atms")
@Data
public class Atm {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "in")
    private Integer in;

    @Column(name = "out")
    private Integer out;

    @Column(name = "expected")
    private Double expected;

    @Column(name = "dispersion")
    private Double dispersion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return Objects.equals(id, atm.id) &&
                Objects.equals(in, atm.in) &&
                Objects.equals(out, atm.out) &&
                Objects.equals(expected, atm.expected) &&
                Objects.equals(dispersion, atm.dispersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, in, out, expected, dispersion);
    }


}
