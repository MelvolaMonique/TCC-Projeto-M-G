package br.com.etec.mogi.TCCprojeto.repository.projections;

public class ClienteDTO {
  private Integer id;
  private String nomecliente;
  private String endereco;
  private String nomecidade;

  public ClienteDTO(Integer id, String nomecliente, String endereco, String nomecidade) {
    this.id = id;
    this.nomecliente = nomecliente;
    this.endereco = endereco;
    this.nomecidade = nomecidade;
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

  public String getNomecidade() {
    return nomecidade;
  }

  public void setNomecidade(String nomecidade) {
    this.nomecidade = nomecidade;
  }
}
