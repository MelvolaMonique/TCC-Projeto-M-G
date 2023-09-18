package br.com.etec.mogi.TCCprojeto.repository.filter;

public class AnimalFilter {

  private String nomeanimal;
  private String nomecliente;
  private String idade;
  private String sexo;
  private String castracao;
  private String raca;
  private String especie;

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

  public String getRaca() {
    return raca;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  public String getEspecie() {
    return especie;
  }

  public void setEspecie(String especie) {
    this.especie = especie;
  }
}
