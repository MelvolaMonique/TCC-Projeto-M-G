package br.com.etec.mogi.TCCprojeto.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate datahora;

    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Medico medico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  public LocalDate getDatahora() {
    return datahora;
  }

  public void setDatahora(LocalDate datahora) {
    this.datahora = datahora;
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
