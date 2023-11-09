package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.model.Consulta;
import br.com.etec.mogi.TCCprojeto.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ConsultaService {
  @Autowired
  private ConsultaRepository consultaRepository;

  public Consulta salvar(Consulta consulta){
    return consultaRepository.save(consulta);
  }
  public Consulta atualizar(Integer id, Consulta consulta) throws IllegalAccessException {
    Consulta consultasalva = busconsultaexistente(id);
    return consultaRepository.save(consultasalva);
  }
  private Consulta busconsultaexistente(Integer id) throws IllegalAccessException{
    Optional<Consulta> consultasalva=consultaRepository.findById(id);
    if (!consultasalva.isPresent()){
      throw new IllegalAccessException();
    }
    return consultasalva.get();
  }
}
