package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Raca;
import br.com.etec.mogi.TCCprojeto.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RacaService {
  @Autowired
  private RacaRepository racaRepository;

  public Raca salvar(Raca raca){
    return racaRepository.save(raca);
  }
  public Raca atualizar(Integer id, Raca raca) throws IllegalAccessException{
    Raca racasalva = busracaexistente(id);
    return racaRepository.save(racasalva);
  }
  private Raca busracaexistente(Integer id) throws IllegalAccessException{
    Optional<Raca> racasalva=racaRepository.findById(id);
    if (!racasalva.isPresent()){
      throw new IllegalAccessException();
    }
    return racasalva.get();
  }
}
