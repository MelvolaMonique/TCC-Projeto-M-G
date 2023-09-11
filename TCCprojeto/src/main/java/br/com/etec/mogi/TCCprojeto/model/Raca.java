package br.com.etec.mogi.TCCprojeto.model;

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
    private String descricao;

    @OneToMany(mappedBy = "raca")
    private List<Animal> animaisraca = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
