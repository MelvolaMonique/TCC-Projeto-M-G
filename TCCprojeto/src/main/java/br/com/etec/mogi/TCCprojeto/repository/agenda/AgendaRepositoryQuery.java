package br.com.etec.mogi.TCCprojeto.repository.agenda;

import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AgendaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgendaRepositoryQuery {
  public Page <AgendaDTO> Filtrar(AgendaFilter agendaFilter, Pageable pageable);


}
