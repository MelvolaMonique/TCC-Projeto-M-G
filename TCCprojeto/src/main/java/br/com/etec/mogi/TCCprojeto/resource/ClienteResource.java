package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Cliente;
import br.com.etec.mogi.TCCprojeto.repository.ClienteRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.ClienteFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id){clienteRepository.deleteById(id);}

  @PutMapping("/mudar-cliente/{id}")
  public HttpStatus mudagem(@PathVariable Integer id, @RequestBody Cliente clienteRequest){
    return clienteRepository.findById(id).map(
      cliente -> {
        cliente.setNomecliente(clienteRequest.getNomecliente());
        cliente.setEndereco(clienteRequest.getEndereco());
        cliente.setTele1(clienteRequest.getTele1());
        cliente.setTele2(clienteRequest.getTele2());
        cliente.setCPF(clienteRequest.getCPF());
        cliente.setRG(clienteRequest.getRG());

        clienteRepository.save(cliente);
        return HttpStatus.OK;
      }
    ).orElseGet(()-> {
      return HttpStatus.NOT_FOUND;
    });
  }
  @PostMapping()
  public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){
    return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.CREATED);
  }

  }
