package br.com.etec.mogi.TCCprojeto.repository.projections;

import java.util.Date;

public class MedicoDTO{
  private Integer id;
  private String nomemedico;
  private String telefone;
  private Date datahoraconsulta;
  private String nomeanimal;
  private String descricaoEs;

  public MedicoDTO(Integer id, String nomemedico, String telefone, Date datahoraconsulta, String nomeanimal, String descricaoEs) {
    this.id = id;
    this.nomemedico = nomemedico;
    this.telefone = telefone;
    this.datahoraconsulta = datahoraconsulta;
    this.nomeanimal = nomeanimal;
    this.descricaoEs = descricaoEs;
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

  public Date getDatahoraconsulta() {
    return datahoraconsulta;
  }

  public void setDatahoraconsulta(Date datahoraconsulta) {
    this.datahoraconsulta = datahoraconsulta;
  }

  public String getNomeanimal() {
    return nomeanimal;
  }

  public void setNomeanimal(String nomeanimal) {
    this.nomeanimal = nomeanimal;
  }

  public String getDescricaoEs() {
    return descricaoEs;
  }

  public void setDescricaoEs(String descricaoEs) {
    this.descricaoEs = descricaoEs;
  }
}


