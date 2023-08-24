package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Cliente;
import br.com.etec.mogi.TCCprojeto.repository.ClienteReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

  @Autowired
  private ClienteReposiory clienteReposiory;

  @GetMapping("/todos")
  public List<Cliente> listartodosclientes(){
    return clienteReposiory.findAll();
  }
}
