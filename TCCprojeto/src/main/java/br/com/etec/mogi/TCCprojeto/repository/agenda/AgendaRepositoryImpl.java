package br.com.etec.mogi.TCCprojeto.repository.agenda;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AgendaRepositoryImpl implements AgendaRepositoryQuery {

  @Override
  public Page<Agenda> Filtrar(AgendaFilter agendaFilter, Pageable pageable) {
    return null;
  }
  @PersistenceContext
  private EntityManager manager;

  CriteriaBuilder builder = manager.getCriteriaBuilder();
  CriteriaQuery<Agenda> criteria = builder.createQuery(Agenda.class);
  Root<Agenda> root = criteria.from(Agenda.class);
  

}
