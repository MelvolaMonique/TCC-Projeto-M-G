package br.com.etec.mogi.TCCprojeto.repository.agenda;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AgendaRepositoryQuery {
  public Page <Agenda> Filtrar(AgendaFilter agendaFilter, Pageable pageable);


}
