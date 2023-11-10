package br.com.etec.mogi.TCCprojeto.repository.projections;

import java.time.LocalDate;
import java.util.Date;

public class AgendaDTO {
  private Integer id;
  private String nomemedico;
  private String telefone;
  private LocalDate datahora;

  public AgendaDTO(Integer id, String nomemedico, String telefone, LocalDate datahora) {
    this.id = id;
    this.nomemedico = nomemedico;
    this.telefone = telefone;
    this.datahora = datahora;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public LocalDate getDatahora() {
    return datahora;
  }

  public void setDatahora(LocalDate datahora) {
    this.datahora = datahora;
  }
}
