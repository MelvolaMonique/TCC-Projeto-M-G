package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Cliente;
import br.com.etec.mogi.TCCprojeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClienteService {
  @Autowired
  private ClienteRepository clienteRepository;

  public Cliente salvar(Cliente cliente){
    return clienteRepository.save(cliente);
  }
  public Cliente atualizar(Integer id, Cliente cliente) throws IllegalAccessException {
  Cliente clientesalva = busclienteexistente(id);
  return clienteRepository.save(clientesalva);
  }
  private Cliente busclienteexistente(Integer id) throws IllegalAccessException {
    Optional<Cliente> clientesalva=clienteRepository.findById(id);
    if(!clientesalva.isPresent()){
      throw new IllegalAccessException();
    }
    return clientesalva.get();
  }
}
