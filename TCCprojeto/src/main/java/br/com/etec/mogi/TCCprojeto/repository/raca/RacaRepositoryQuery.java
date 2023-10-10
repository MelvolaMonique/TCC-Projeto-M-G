package br.com.etec.mogi.TCCprojeto.repository.raca;

import br.com.etec.mogi.TCCprojeto.model.Raca;
import br.com.etec.mogi.TCCprojeto.repository.filter.RacaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RacaRepositoryQuery {

  public Page<Raca> filtrar(RacaFilter racaFilter, Pageable pageable);
}
