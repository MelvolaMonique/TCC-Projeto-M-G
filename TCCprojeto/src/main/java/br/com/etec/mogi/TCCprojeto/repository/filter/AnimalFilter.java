package br.com.etec.mogi.TCCprojeto.repository.filter;

public class AnimalFilter {

  private String nomeanimal;
  private String nomecliente;
  private String idade;
  private String sexo;
  private String castracao;
  private String descricaoRa;
  private String descricaoEs;

  public String getNomeanimal() {
    return nomeanimal;
  }

  public void setNomeanimal(String nomeanimal) {
    this.nomeanimal = nomeanimal;
  }

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getCastracao() {
    return castracao;
  }

  public void setCastracao(String castracao) {
    this.castracao = castracao;
  }

  public String getIdade() {
    return idade;
  }

  public void setIdade(String idade) {
    this.idade = idade;
  }

  public String getDescricaoRa() {
    return descricaoRa;
  }

  public void setDescricaoRa(String descricaoRa) {
    this.descricaoRa = descricaoRa;
  }

  public String getDescricaoEs() {
    return descricaoEs;
  }

  public void setDescricaoEs(String descricaoEs) {
    this.descricaoEs = descricaoEs;
  }
}
