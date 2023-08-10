package br.com.etec.mogi.TCCprojeto.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permissao")

public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomepermissao;
    private String descricao;
    private Integer codigopermissao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomepermissao() {
        return nomepermissao;
    }

    public void setNomepermissao(String nomepermissao) {
        this.nomepermissao = nomepermissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigopermissao() {
        return codigopermissao;
    }

    public void setCodigopermissao(Integer codigopermissao) {
        this.codigopermissao = codigopermissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permissao)) return false;
        Permissao permissao = (Permissao) o;
        return id.equals(permissao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
