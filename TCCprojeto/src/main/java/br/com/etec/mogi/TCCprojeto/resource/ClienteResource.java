package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.model.Cliente;
import br.com.etec.mogi.TCCprojeto.repository.AgendaRepository;
import br.com.etec.mogi.TCCprojeto.repository.ClienteRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import br.com.etec.mogi.TCCprojeto.repository.filter.ClienteFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AgendaDTO;
import br.com.etec.mogi.TCCprojeto.repository.projections.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")

public class ClienteResource {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping("/todos")
  public List<Cliente> listartodosclientes(){
    return clienteRepository.findAll();
  }
  @GetMapping()
  public Page<ClienteDTO> pesquisar(ClienteFilter clienteFilter, Pageable pageable){
    return clienteRepository.Filtrar(clienteFilter, pageable);
  }
}
