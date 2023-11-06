package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AgendaService {
  @Autowired
  private AgendaRepository agendaRepository;

  public Agenda salvar(Agenda agenda){
    return agendaRepository.save(agenda);
  }
  public Agenda atualizar(Integer id, Agenda agenda) throws IllegalAccessException {
    Agenda agendasalva = busagendaexistente(id);
    return agendaRepository.save(agendasalva);
  }

  private Agenda busagendaexistente(Integer id) throws IllegalAccessException {
    Optional<Agenda> agendasalva=agendaRepository.findById(id);
    if (!agendasalva.isPresent()){
      throw new IllegalAccessException();


    }
    return agendasalva.get();
  }
}
