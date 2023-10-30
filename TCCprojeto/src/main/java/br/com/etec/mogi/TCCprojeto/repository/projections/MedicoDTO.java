package br.com.etec.mogi.TCCprojeto.repository.projections;

import java.util.Date;

public class MedicoDTO{
  private Integer id;
  private String nomemedico;
  private String telefone;


  public MedicoDTO(Integer id, String nomemedico, String telefone) {
    this.id = id;
    this.nomemedico = nomemedico;
    this.telefone = telefone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNomemedico() {
    return nomemedico;
  }

  public void setNomemedico(String nomemedico) {
    this.nomemedico = nomemedico;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

}


