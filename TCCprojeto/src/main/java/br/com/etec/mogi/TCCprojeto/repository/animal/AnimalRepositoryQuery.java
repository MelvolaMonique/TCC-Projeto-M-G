package br.com.etec.mogi.TCCprojeto.repository.animal;

import br.com.etec.mogi.TCCprojeto.repository.filter.AnimalFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AnimalDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalRepositoryQuery {
  public Page<AnimalDTO> filtrar(AnimalFilter animalFilter, Pageable pageable);

}
