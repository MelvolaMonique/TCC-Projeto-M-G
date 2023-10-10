package br.com.etec.mogi.TCCprojeto.repository.especie;

import br.com.etec.mogi.TCCprojeto.model.Especie;
import br.com.etec.mogi.TCCprojeto.repository.filter.EspecieFilter;
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

public class EspecieRepositoryImpl implements EspecieRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Especie> Filtrar(EspecieFilter especieFilter, Pageable pageable){

    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Especie> criteria = builder.createQuery(Especie.class);
    Root<Especie> root = criteria.from(Especie.class);

    Predicate[] predicates = CriarRestricoes(especieFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("descricaoEs")));

    TypedQuery<Especie> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);
    return new PageImpl<>(query.getResultList(), pageable, total(especieFilter));
  }

  private Long total(EspecieFilter especieFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Especie> root = criteria.from(Especie.class);

    Predicate[] predicates = CriarRestricoes(especieFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("descricaoEs")));

    criteria.select(builder.count(root));

    return  manager.createQuery(criteria). getSingleResult();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Especie> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorDia = pageable.getPageSize();
    int primeiroRegristrosPorPagina = paginaAtual * totalRegistrosPorDia;

    query.setFirstResult(primeiroRegristrosPorPagina);
    query.setMaxResults(totalRegistrosPorDia);
  }

  private Predicate[] CriarRestricoes(EspecieFilter especieFilter, CriteriaBuilder builder, Root<Especie> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(especieFilter.getDescricaoEs())){
      predicates.add(builder.like(builder.lower(root.get("descricaoEs")),
        "%" + especieFilter.getDescricaoEs().toLowerCase() + "%"));
    }
return predicates.toArray(new Predicate[predicates.size()]);
  }
}
