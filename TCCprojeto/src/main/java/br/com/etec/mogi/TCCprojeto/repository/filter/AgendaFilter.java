package br.com.etec.mogi.TCCprojeto.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;



public class AgendaFilter {

  @DateTimeFormat(pattern="yyyy/MM/dd")
  private LocalDate datahora;
  private String nomemedico;
  private String telefone;

  public LocalDate getDatahora() {
    return datahora;
  }

  public void setDatahora(LocalDate datahora) {
    this.datahora = datahora;
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

}
