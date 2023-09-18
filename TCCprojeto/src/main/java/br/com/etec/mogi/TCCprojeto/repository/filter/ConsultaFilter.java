package br.com.etec.mogi.TCCprojeto.repository.filter;

import java.util.Date;

public class ConsultaFilter {
  private Date datahora;
  private String animal;
  private String nomemedico;

  public Date getDatahora() {
    return datahora;
  }

  public void setDatahora(Date datahora) {
    this.datahora = datahora;
  }

  public String getAnimal() {
    return animal;
  }

  public void setAnimal(String animal) {
    this.animal = animal;
  }

  public String getNomemedico() {
    return nomemedico;
  }

  public void setNomemedico(String nomemedico) {
    this.nomemedico = nomemedico;
  }
}
