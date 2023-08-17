package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendas")

public class AgendaResource {

  @Autowired
  private AgendaRepository agendaRepository;

  @GetMapping("/todos")
  public List<Agenda> listartodosagendamentos(){
    return agendaRepository.findAll();
  }
}
