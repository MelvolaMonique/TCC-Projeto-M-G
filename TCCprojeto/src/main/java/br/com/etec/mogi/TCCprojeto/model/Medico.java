package br.com.etec.mogi.TCCprojeto.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private String CPF;
    private String RG;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultasmedico = new ArrayList<>();

    @OneToMany(mappedBy = "medico")
    private List<Agenda> agendamedico = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

  public List<Consulta> getConsultasmedico() {
    return consultasmedico;
  }

  public void setConsultasmedico(List<Consulta> consultasmedico) {
    this.consultasmedico = consultasmedico;
  }

  public List<Agenda> getAgendamedico() {
    return agendamedico;
  }

  public void setAgendamedico(List<Agenda> agendamedico) {
    this.agendamedico = agendamedico;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico)) return false;
        Medico medico = (Medico) o;
        return id.equals(medico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
