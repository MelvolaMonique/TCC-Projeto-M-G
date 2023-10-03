package br.com.etec.mogi.TCCprojeto.repository.consulta;

import br.com.etec.mogi.TCCprojeto.model.Consulta;
import br.com.etec.mogi.TCCprojeto.repository.filter.ConsultaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.ConsultaDTO;
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

public class ConsultaRepositoryImpl implements  ConsultaRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<ConsultaDTO> Filtrar(ConsultaFilter consultaFilter, Pageable pageable){

    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<ConsultaDTO> criteria = builder.createQuery(ConsultaDTO.class);
    Root<Consulta> root = criteria.from(Consulta.class);

    criteria.select(builder.construct(ConsultaDTO.class
      ,root.get("id")
      ,root.get("datahoraconsulta")
      ,root.get("historico")
      ,root.get("animal").get("nomeanimal")
      ,root.get("medico").get("nomemedico")
    ));
    Predicate[] predicates =CriarRestricoes(consultaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("datahoraconsulta")));

    TypedQuery<ConsultaDTO> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(consultaFilter));
  }

  private Predicate[] CriarRestricoes(ConsultaFilter consultaFilter, CriteriaBuilder builder, Root<Consulta> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (consultaFilter.getDatahoraconsulta() != null) {
      predicates.add(builder.greaterThanOrEqualTo(root.get("datahoraconsulta"),
        consultaFilter.getDatahoraconsulta()));

    }
    if(!StringUtils.isEmpty(consultaFilter.get())) {
      predicates.add(builder.like(builder.lower(root.get("medico").get("nomemedico")),
        "%" + consultaFilter.getNomemedico().toLowerCase() + "%"));
    }

    if(!StringUtils.isEmpty(consultaFilter.getNomemedico())) {
      predicates.add(builder.like(builder.lower(root.get("medico").get("nomemedico")),
        "%" + consultaFilter.getNomemedico().toLowerCase() + "%"));
    }
    return predicates.toArray(new Predicate[predicates.size()]);
  }
  private void  adicionarRestricoesDePaginacao(TypedQuery<ConsultaDTO> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorDia = pageable.getPageSize();
    int primeiroRegistrosPorPagina = paginaAtual * totalRegistrosPorDia;

    query.setFirstResult(primeiroRegistrosPorPagina);
    query.setMaxResults(totalRegistrosPorDia);
  }

  private Long total(ConsultaFilter consultaFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Consulta> root = criteria.from(Consulta.class);

    Predicate[] predicates = CriarRestricoes(consultaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("datahoraconsulta")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }
  }
