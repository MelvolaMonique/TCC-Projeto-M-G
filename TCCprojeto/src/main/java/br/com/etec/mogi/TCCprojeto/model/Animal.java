package br.com.etec.mogi.TCCprojeto.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "animal")

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeanimal;
    private String idade;
    private String sexo;
    private String castracao;

    @OneToMany(mappedBy = "animal")
    private List<Consulta> consultasanimal = new ArrayList<>();

    @ManyToOne
    @JoinColumn (name = "idraca")
    private Raca raca;

    @ManyToOne
    @JoinColumn (name = "idespecie")
    private Especie especie;

    @ManyToOne
    @JoinColumn (name = "idcliente")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeanimal() {
        return nomeanimal;
    }

    public void setNomeanimal(String nomeanimal) {
        this.nomeanimal = nomeanimal;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCastracao() {
        return castracao;
    }

    public void setCastracao(String castracao) {
        this.castracao = castracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
