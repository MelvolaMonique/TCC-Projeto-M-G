package br.com.etec.mogi.TCCprojeto.repository.filter;

import java.util.Date;

public class ConsultaFilter {
  private Date datahoraconsulta;
  private String animal;
  private String nomemedico;

  public Date getDatahoraconsulta() {
    return datahoraconsulta;
  }

  public void setDatahoraconsulta(Date datahoraconsulta) {
    this.datahoraconsulta = datahoraconsulta;
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
