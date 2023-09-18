package br.com.etec.mogi.TCCprojeto.repository.filter;

public class ClienteFilter {
  private String nomecliente;
  private String endereco;
  private String nomeanimal;

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getNomeanimal() {
    return nomeanimal;
  }

  public void setNomeanimal(String nomeanimal) {
    this.nomeanimal = nomeanimal;
  }
}
