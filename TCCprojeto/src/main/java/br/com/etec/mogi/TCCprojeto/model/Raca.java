package br.com.etec.mogi.TCCprojeto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "raca")

public class Raca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricaoRa;

    @JsonIgnore
    @OneToMany(mappedBy = "raca")
    private List<Animal> animaisraca = new ArrayList<>();

    public Integer getId() {
        return id;
    }

  public String getDescricaoRa() {
    return descricaoRa;
  }
  public void setDescricaoRa(String descricaoRa) {
    this.descricaoRa = descricaoRa;
  }

  public void setId(Integer id) {
        this.id = id;
    }

  public List<Animal> getAnimaisraca() {
    return animaisraca;
  }

  public void setAnimaisraca(List<Animal> animaisraca) {
    this.animaisraca = animaisraca;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Raca)) return false;
        Raca raca = (Raca) o;
        return id.equals(raca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
