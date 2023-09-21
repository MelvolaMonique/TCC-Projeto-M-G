package br.com.etec.mogi.TCCprojeto.repository.projections;

public class AnimalDTO {
  private Integer id;
  private String nomeanimal;
  private String idade;
  private String sexo;
  private String castracao;
  private String descricaoRa;
  private String descricaoEs;
  private String nomecliente;

  public AnimalDTO(Integer id, String nomeanimal, String idade, String sexo, String castracao, String descricaoRa, String descricaoEs, String nomecliente) {
    this.id = id;
    this.nomeanimal = nomeanimal;
    this.idade = idade;
    this.sexo = sexo;
    this.castracao = castracao;
    this.descricaoRa = descricaoRa;
    this.descricaoEs = descricaoEs;
    this.nomecliente = nomecliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNomeanimal() {
    return nomeanimal;
  }

  public void setNomeanimal(String nomeanimal) {
    this.nomeanimal = nomeanimal;
  }

  public String getIdade() {
    return idade;
  }

  public void setIdade(String idade) {
    this.idade = idade;
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

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }
}
