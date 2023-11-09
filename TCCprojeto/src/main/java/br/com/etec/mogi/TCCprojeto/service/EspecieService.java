package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.model.Especie;
import br.com.etec.mogi.TCCprojeto.repository.AgendaRepository;
import br.com.etec.mogi.TCCprojeto.repository.EspecieRepository;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EspecieService {
  @Autowired
  private EspecieRepository especieRepository;

  public Especie salvar(Especie especie){
    return especieRepository.save(especie);
  }
  public Especie atualizar(Integer id, Especie especie) throws IllegalAccessException {
    Especie especiesalva = busespecieexistente(id);
    return especieRepository.save(especiesalva);
  }
  private Especie busespecieexistente(Integer id) throws IllegalAccessException {
    Optional<Especie> especiesalva=especieRepository.findById(id);
    if (!especiesalva.isPresent()){
      throw new IllegalAccessException();


    }
    return especiesalva.get();
  }
}
