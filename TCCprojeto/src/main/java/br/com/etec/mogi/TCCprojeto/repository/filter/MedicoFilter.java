package br.com.etec.mogi.TCCprojeto.repository.filter;

import java.util.Date;

public class MedicoFilter {
  private String nomemedico;
  private String telefone;

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
