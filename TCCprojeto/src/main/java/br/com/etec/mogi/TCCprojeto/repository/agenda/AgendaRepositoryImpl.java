package br.com.etec.mogi.TCCprojeto.repository.agenda;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AgendaRepositoryImpl implements AgendaRepositoryQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Agenda> Filtrar(AgendaFilter agendaFilter, Pageable pageable) {


    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Agenda> criteria = builder.createQuery(Agenda.class);
    Root<Agenda> root = criteria.from(Agenda.class);

    Predicate[] predicates = CriarRestricoes(agendaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("datahoraconsulta")));

    TypedQuery<Agenda> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);
    return new PageImpl<>(query.getResultList(), pageable, total(agendaFilter));


  }


  private Object total(AgendaFilter agendaFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Integer> criteria = builder.createQuery(Integer.class);
    Root<Agenda> root = criteria.from(Agenda.class);

    Predicate[] predicates = CriarRestricoes(agendaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("datahoraconsulta")));


    return manager.createQuery(criteria).getResultList();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Agenda> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorDia = pageable.getPageSize();
    int primeiroRegistrosPorPagina = paginaAtual * totalRegistrosPorDia;

    query.setFirstResult(primeiroRegistrosPorPagina);
    query.setMaxResults(totalRegistrosPorDia);
  }
  private Predicate[] CriarRestricoes(AgendaFilter agendaFilter, CriteriaBuilder builder, Root<Agenda> root) {
    List<Predicate> predicates = new ArrayList<>();


    return predicates.toArray(new Predicate[predicates.size()]);
    }



  }





