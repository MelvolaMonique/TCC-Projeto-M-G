package br.com.etec.mogi.TCCprojeto.repository.projections;

import java.util.Date;

public class AgendaDTO {
  private Integer id;
  private Date datahoraconsulta;
  private String nomemedico;
  private String telefone;
  private String nomeanimal;
  private String nomecliente;

  public AgendaDTO(Integer id, Date datahoraconsulta, String nomemedico, String telefone, String nomeanimal, String nomecliente) {
    this.id = id;
    this.datahoraconsulta = datahoraconsulta;
    this.nomemedico = nomemedico;
    this.telefone = telefone;
    this.nomeanimal = nomeanimal;
    this.nomecliente = nomecliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDatahoraconsulta() {
    return datahoraconsulta;
  }

  public void setDatahoraconsulta(Date datahoraconsulta) {
    this.datahoraconsulta = datahoraconsulta;
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

  public String getNomeanimal() {
    return nomeanimal;
  }

  public void setNomeanimal(String nomeanimal) {
    this.nomeanimal = nomeanimal;
  }

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }
}
