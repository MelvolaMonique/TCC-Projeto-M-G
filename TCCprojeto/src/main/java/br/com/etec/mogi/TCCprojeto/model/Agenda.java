package br.com.etec.mogi.TCCprojeto.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dataconsulta;
    private Date horaconsulta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(Date dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public Date getHoraconsulta() {
        return horaconsulta;
    }

    public void setHoraconsulta(Date horaconsulta) {
        this.horaconsulta = horaconsulta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agenda)) return false;
        Agenda agenda = (Agenda) o;
        return id.equals(agenda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
