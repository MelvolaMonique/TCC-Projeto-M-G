package br.com.etec.mogi.TCCprojeto.repository.filter;

import java.util.Date;

public class ConsultaFilter {
  private Date datahoraconsulta;
  private String historico;
  private String nomeanimal;
  private String nomemedico;

  public Date getDatahoraconsulta() {
    return datahoraconsulta;
  }

  public void setDatahoraconsulta(Date datahoraconsulta) {
    this.datahoraconsulta = datahoraconsulta;
  }

  public String getHistorico() {
    return historico;
  }

  public void setHistorico(String historico) {
    this.historico = historico;
  }

  public String getNomeanimal() {
    return nomeanimal;
  }

  public void setNomeanimal(String nomeanimal) {
    this.nomeanimal = nomeanimal;
  }

  public String getNomemedico() {
    return nomemedico;
  }

  public void setNomemedico(String nomemedico) {
    this.nomemedico = nomemedico;
  }
}
