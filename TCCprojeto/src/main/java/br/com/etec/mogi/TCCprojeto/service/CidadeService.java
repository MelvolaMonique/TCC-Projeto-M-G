package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Cidade;
import br.com.etec.mogi.TCCprojeto.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CidadeService {

  @Autowired
  private CidadeRepository cidadeRepository;

  public Cidade salvar (Cidade cidade){
    return cidadeRepository.save(cidade);
  }
  public Cidade atualizar(Integer id, Cidade cidade) throws IllegalAccessException{
    Cidade cidadesalva = buscidadeexistente(id);
    return cidadeRepository.save(cidadesalva);
  }
  private Cidade buscidadeexistente(Integer id) throws IllegalAccessException{
    Optional<Cidade> cidadesalva= cidadeRepository.findById(id);
  if (!cidadesalva.isPresent()){
    throw new IllegalAccessException();
  }
  return cidadesalva.get();
  }
}
