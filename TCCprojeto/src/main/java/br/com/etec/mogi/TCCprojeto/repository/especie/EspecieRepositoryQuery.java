package br.com.etec.mogi.TCCprojeto.repository.especie;

import br.com.etec.mogi.TCCprojeto.model.Especie;
import br.com.etec.mogi.TCCprojeto.repository.filter.EspecieFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EspecieRepositoryQuery {

  public Page<Especie> Filtrar(EspecieFilter especieFilter, Pageable pageable);
}
