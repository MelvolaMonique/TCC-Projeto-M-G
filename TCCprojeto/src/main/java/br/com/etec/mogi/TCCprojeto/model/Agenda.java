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
    private Date datahoraconsulta;

    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Medico medico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  public Date getDatahoraconsulta() {
    return datahoraconsulta;
  }

  public void setDatahoraconsulta(Date datahoraconsulta) {
    this.datahoraconsulta = datahoraconsulta;
  }

  public Medico getMedico() {
    return medico;
  }

  public void setMedico(Medico medico) {
    this.medico = medico;
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
