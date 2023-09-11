package br.com.etec.mogi.TCCprojeto.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   private Long codigo;
    private String nomeusuario;
    private String tele1;
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuariopermissao", joinColumns = @JoinColumn(name = "codigousuario")
  , inverseJoinColumns = @JoinColumn(name = "codigopermissao"))
  private List<Permissao> permissoes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public List<Permissao> getPermissoes() {
    return permissoes;
  }

  public void setPermissoes(List<Permissao> permissoes) {
    this.permissoes = permissoes;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
