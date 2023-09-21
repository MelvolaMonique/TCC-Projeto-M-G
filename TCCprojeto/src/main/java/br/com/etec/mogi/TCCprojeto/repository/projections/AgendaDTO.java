package br.com.etec.mogi.TCCprojeto.repository.projections;

import java.util.Date;

public class AgendaDTO {
  private Integer id;
  private Date datahoraconsulta;
  private String nomemedico;
  private String telefone;
  private Date datahora;
  private String historico;
  private String nomeanimal;

  public AgendaDTO(Integer id, Date datahoraconsulta, String nomemedico, String telefone, Date datahora, String historico, String nomeanimal) {
    this.id = id;
    this.datahoraconsulta = datahoraconsulta;
    this.nomemedico = nomemedico;
    this.telefone = telefone;
    this.datahora = datahora;
    this.historico = historico;
    this.nomeanimal = nomeanimal;
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

  public Date getDatahora() {
    return datahora;
  }

  public void setDatahora(Date datahora) {
    this.datahora = datahora;
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
}
