package br.com.etec.mogi.TCCprojeto.repository.filter;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class AgendaFilter {

  private Date datahoraconsulta;
  private String nomemedico;

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
}
