package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.AgendaRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AgendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")

public class AgendaResource {

  @Autowired
  private AgendaRepository agendaRepository;

  @GetMapping("/todos")
  public List<Agenda> listartodosagendamentos() {
    return agendaRepository.findAll();
  }

  @GetMapping()
  public Page<AgendaDTO> pesquisar(AgendaFilter agendaFilter, Pageable pageable) {
    return agendaRepository.Filtrar(agendaFilter, pageable);
  }

@DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id){agendaRepository.deleteById(id);}

  @PutMapping("/mudar-agenda/{id}")
  public HttpStatus mudaragem(@PathVariable Integer id, @RequestBody Agenda agendaRequest){
    return agendaRepository.findById(id).map(
      agenda -> {
        agenda.setDatahora(agendaRequest.getDatahora());

        agendaRepository.save(agenda);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });
  }
  @PostMapping()
  public ResponseEntity<Agenda> criar(@RequestBody Agenda agenda){

    return new ResponseEntity<>(agendaRepository.save(agenda),HttpStatus.CREATED);
  }
}

