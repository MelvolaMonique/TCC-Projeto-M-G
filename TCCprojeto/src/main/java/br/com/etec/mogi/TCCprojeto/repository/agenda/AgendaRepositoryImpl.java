package br.com.etec.mogi.TCCprojeto.repository.agenda;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.repository.filter.AgendaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AgendaDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
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

    criteria.select(builder.construct(AgendaDTO.class
      ,root.get("id")
      ,root.get("medico").get("nomemedico")
      ,root.get("medico").get("telefone")
      ,root.get("medico").get("consulta").get("animal").get("nomeanimal")
      ,root.get("medico").get("consulta").get("animal").get("cliente").get("nomecliente")
      ,root.get("medico").get("consulta").get("datahoraconsulta")
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

    if (agendaFilter.getDatahoraconsulta() != null){
      predicates.add(builder.greaterThanOrEqualTo(root.get("datahoraconsulta"),
        agendaFilter.getDatahoraconsulta()));
    }
    if(!StringUtils.isEmpty(agendaFilter.getNomemedico())) {
      predicates.add(builder.like(builder.lower(root.get("medico").get("nomemedico")),
        "%" + agendaFilter.getTelefone().toLowerCase() + "%"));
    }
    if (!StringUtils.isEmpty(agendaFilter.getTelefone())){
      predicates.add(builder.like(builder.lower(root.get("medico").get("telefone")),
        agendaFilter.getTelefone()));
    }
    if (!StringUtils.isEmpty(agendaFilter.getNomeanimal())){
      predicates.add(builder.like(builder.lower(root.get("consulta").get("animal").get("nomeanimal")),
        "%" + agendaFilter.getNomeanimal().toLowerCase() + "%"));
    }
    if (!StringUtils.isEmpty(agendaFilter.getNomecliente())){
      predicates.add(builder.like(builder.lower(root.get("consulta").get("cliente").get("nomecliente")),
        "%" + agendaFilter.getNomecliente().toLowerCase() + "%"));
    }


    return predicates.toArray(new Predicate[predicates.size()]);
  }


  private void adicionarRestricoesDePaginacao(TypedQuery<AgendaDTO> query, Pageable pageable) {
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
  }





