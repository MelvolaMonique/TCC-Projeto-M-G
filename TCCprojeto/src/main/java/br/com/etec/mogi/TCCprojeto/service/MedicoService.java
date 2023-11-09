package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Medico;
import br.com.etec.mogi.TCCprojeto.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MedicoService {
  @Autowired
  private MedicoRepository medicoRepository;

  public Medico salvar (Medico medico){
    return medicoRepository.save(medico);
  }
  public Medico atualizar(Integer id, Medico medico) throws IllegalAccessException{
    Medico medicosalva = busmedicoexistente(id);
    return medicoRepository.save(medicosalva);
  }
  private Medico busmedicoexistente(Integer id) throws IllegalAccessException{
    Optional<Medico> medicosalva=medicoRepository.findById(id);
    if (!medicosalva.isPresent()){
      throw new IllegalAccessException();
    }
    return medicosalva.get();
  }
}
