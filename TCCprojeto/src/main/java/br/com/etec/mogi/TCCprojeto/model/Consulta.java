package br.com.etec.mogi.TCCprojeto.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "consulta")

public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date data;
    private Date hora;
    private String historico;

    @ManyToOne
    @JoinColumn (name = "idanimal")
    private Animal animal;

    @ManyToOne
    @JoinColumn (name = "idmedico")
    private Medico medico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consulta)) return false;
        Consulta consulta = (Consulta) o;
        return id.equals(consulta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
