package br.com.etec.mogi.TCCprojeto.repository.projections;

import java.util.Date;

public class ConsultaDTO {
  private Integer id;
  private Date datahoraconsulta;
  private String historico;
  private String nomeanimal;
  private String nomemedico;

  public ConsultaDTO(Integer id, Date datahoraconsulta, String historico, String nomeanimal, String nomemedico) {
    this.id = id;
    this.datahoraconsulta = datahoraconsulta;
    this.historico = historico;
    this.nomeanimal = nomeanimal;
    this.nomemedico = nomemedico;
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
