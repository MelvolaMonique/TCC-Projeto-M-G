package br.com.etec.mogi.TCCprojeto.repository.projections;

public class ClienteDTO {
  private Integer id;
  private String nomecliente;
  private String endereco;
  private String tele1;
  private String tele2;
  private String CPF;
  private String RG;
  private String nomecidade;
  private String nomeanimal;

  public ClienteDTO(Integer id, String nomecliente, String endereco, String tele1, String tele2, String CPF, String RG, String nomecidade, String nomeanimal) {
    this.id = id;
    this.nomecliente = nomecliente;
    this.endereco = endereco;
    this.tele1 = tele1;
    this.tele2 = tele2;
    this.CPF = CPF;
    this.RG = RG;
    this.nomecidade = nomecidade;
    this.nomeanimal = nomeanimal;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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

  public String getTele1() {
    return tele1;
  }

  public void setTele1(String tele1) {
    this.tele1 = tele1;
  }

  public String getTele2() {
    return tele2;
  }

  public void setTele2(String tele2) {
    this.tele2 = tele2;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public String getRG() {
    return RG;
  }

  public void setRG(String RG) {
    this.RG = RG;
  }

  public String getNomecidade() {
    return nomecidade;
  }

  public void setNomecidade(String nomecidade) {
    this.nomecidade = nomecidade;
  }

  public String getNomeanimal() {
    return nomeanimal;
  }

  public void setNomeanimal(String nomeanimal) {
    this.nomeanimal = nomeanimal;
  }
}
