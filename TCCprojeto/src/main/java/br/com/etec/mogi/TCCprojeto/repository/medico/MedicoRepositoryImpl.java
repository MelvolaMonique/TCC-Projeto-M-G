package br.com.etec.mogi.TCCprojeto.repository.medico;

import br.com.etec.mogi.TCCprojeto.model.Medico;
import br.com.etec.mogi.TCCprojeto.repository.filter.MedicoFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.MedicoDTO;
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

public class MedicoRepositoryImpl implements MedicoRepositoryQuery {

  @PersistenceContext
  private EntityManager manager;


  @Override
  public Page<MedicoDTO> Filtrar(MedicoFilter medicoFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<MedicoDTO> criteria = builder.createQuery(MedicoDTO.class);
    Root<Medico> root = criteria.from(Medico.class);

    criteria.select(builder.construct(MedicoDTO.class
      ,root.get("id")
      ,root.get("nomemedico")
      ,root.get("telefone")
      ));
    Predicate[] predicates = criarRestricoes(medicoFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomemedico")));

    TypedQuery<MedicoDTO> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(medicoFilter));
  }

  private Predicate[] criarRestricoes(MedicoFilter medicoFilter, CriteriaBuilder builder, Root<Medico> root) {
    List<Predicate> predicates = new ArrayList<>();


    if(!StringUtils.isEmpty(medicoFilter.getNomemedico())) {
      predicates.add(builder.like(builder.lower(root.get("nomemedico")),
        "%" + medicoFilter.getNomemedico().toLowerCase() + "%"));
    }
    if(!StringUtils.isEmpty(medicoFilter.getTelefone())) {
      predicates.add(builder.like(builder.lower(root.get("telefone")),
        "%" + medicoFilter.getTelefone().toLowerCase() + "%"));
    }

 return  predicates.toArray(new Predicate[predicates.size()]);
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<MedicoDTO> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorPagina = pageable.getPageSize();
    int primeiroRegistroPagina = paginaAtual * totalRegistrosPorPagina;

    query.setFirstResult(primeiroRegistroPagina);
    query.setMaxResults(totalRegistrosPorPagina);

  }

  private Long total(MedicoFilter medicoFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Medico> root = criteria.from(Medico.class);

    Predicate[] predicates = criarRestricoes(medicoFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomemedico")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }
}
