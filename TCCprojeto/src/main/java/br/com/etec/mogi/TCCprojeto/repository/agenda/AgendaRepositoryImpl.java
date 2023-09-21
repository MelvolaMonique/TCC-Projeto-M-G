package br.com.etec.mogi.TCCprojeto.repository.agenda;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AgendaDTO;
import br.com.etec.mogi.TCCprojeto.repository.projections.AnimalDTO;
import com.mysql.cj.log.Log;
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
  public Page<AgendaDTO> Filtrar(AgendaFilter agendaFilter, Pageable pageable) {


    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<AgendaDTO> criteria = builder.createQuery(AgendaDTO.class);
    Root<Agenda> root = criteria.from(Agenda.class);

    criteria.select(builder.construct(AnimalDTO.class
      ,root.get("id")
      ,root.get("datahoraconsulta")
      ,root.get("medico").get("nomemedico")
      ,root.get("medico").get("telefone")
      ,root.get("consulta").get("datahora")
      ,root.get("consulta").get("historico")
      ,root.get("animal").get("nomeanimal")
    ));
    Predicate[] predicates =CriarRestricoes(agendaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("datahoraconsulta")));

    TypedQuery<AgendaDTO> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(agendaFilter));

  }

  private Predicate[] CriarRestricoes(AgendaFilter agendaFilter, CriteriaBuilder builder, Root<Agenda> root) {
    List<Predicate> predicates = new ArrayList<>();


    return predicates.toArray(new Predicate[predicates.size()]);
  }


  private void adicionarRestricoesDePaginacao(TypedQuery<Agenda> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorDia = pageable.getPageSize();
    int primeiroRegistrosPorPagina = paginaAtual * totalRegistrosPorDia;

    query.setFirstResult(primeiroRegistrosPorPagina);
    query.setMaxResults(totalRegistrosPorDia);
  }
  private Long total(AgendaFilter agendaFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Agenda> root = criteria.from(Agenda.class);

    Predicate[] predicates = CriarRestricoes(agendaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("datahoraconsulta")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();



  }





