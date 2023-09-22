package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.AgendaRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AgendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agenda")

public class
AgendaResource {

  @Autowired
  private AgendaRepository agendaRepository;

  @GetMapping("/todos")
  public List<Agenda> listartodosagendamentos(){
    return agendaRepository.findAll();
  }

  @GetMapping()
  public Page<AgendaDTO> pesquisar(AgendaFilter agendaFilter, Pageable pageable){
    return agendaRepository.Filtrar(agendaFilter, pageable);
  }

}
