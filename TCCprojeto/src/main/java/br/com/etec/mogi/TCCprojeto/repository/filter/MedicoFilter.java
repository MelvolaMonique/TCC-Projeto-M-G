package br.com.etec.mogi.TCCprojeto.repository.filter;

import java.util.Date;

public class MedicoFilter {
  private String nomemedico;
  private Date datahoraconsulta;
  private String nomeanimal;
  private String descricaoEs;

  public String getNomemedico() {
    return nomemedico;
  }

  public void setNomemedico(String nomemedico) {
    this.nomemedico = nomemedico;
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
