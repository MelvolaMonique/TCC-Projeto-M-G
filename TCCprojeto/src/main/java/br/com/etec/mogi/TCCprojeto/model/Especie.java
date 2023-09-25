package br.com.etec.mogi.TCCprojeto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "especie")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricaoEs;

    @JsonIgnore
    @OneToMany
    @JoinColumn (name = "idespecie")
    private List<Animal> animaisespecie = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  public String getDescricaoEs() {
    return descricaoEs;
  }

  public void setDescricaoEs(String descricaoEs) {
    this.descricaoEs = descricaoEs;
  }


  public List<Animal> getAnimaisespecie() {
    return animaisespecie;
  }

  public void setAnimaisespecie(List<Animal> animaisespecie) {
    this.animaisespecie = animaisespecie;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Especie)) return false;
        Especie especie = (Especie) o;
        return id.equals(especie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
