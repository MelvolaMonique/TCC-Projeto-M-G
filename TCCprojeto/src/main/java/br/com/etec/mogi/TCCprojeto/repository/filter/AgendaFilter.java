package br.com.etec.mogi.TCCprojeto.repository.filter;

import java.util.Date;

public class AgendaFilter {

  private Date datahora;
  private String nomemedico;
  private String telefone;


  public String getNomemedico() {
    return nomemedico;
  }

  public void setNomemedico(String nomemedico) {
    this.nomemedico = nomemedico;
  }

  public Date getDatahora() {
    return datahora;
  }

  public void setDatahora(Date datahora) {
    this.datahora = datahora;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

}
