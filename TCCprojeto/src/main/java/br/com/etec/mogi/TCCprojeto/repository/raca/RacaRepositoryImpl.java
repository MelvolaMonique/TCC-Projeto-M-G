package br.com.etec.mogi.TCCprojeto.repository.raca;

import br.com.etec.mogi.TCCprojeto.model.Raca;
import br.com.etec.mogi.TCCprojeto.repository.filter.RacaFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Predicates;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class RacaRepositoryImpl implements RacaRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Raca> filtrar(RacaFilter racaFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Raca> criteria = builder.createQuery(Raca.class);
    Root<Raca> root = criteria.from(Raca.class);

    Predicate[] predicates = CriarRestricoes(racaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("descricaoRa")));

    TypedQuery<Raca> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);
    return new PageImpl<>(query.getResultList(), pageable, total(racaFilter));
  }

  private Predicate[] CriarRestricoes(RacaFilter racaFilter, CriteriaBuilder builder, Root<Raca> root) {
    List<Predicates> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(racaFilter.getDescricaoRa())){
      predicates.add((builder.like(builder.lower(root.get("descricaoRa")),
        "%" + racaFilter.getDescricaoRa().toLowerCase() + "%"));
    }
    if (!StringUtils.isEmpty(racaFilter.getNomeanimal())){
      predicates.add((builder.like(builder.lower(root.get("nomeanimal")),
        "%" + racaFilter.getNomeanimal().toLowerCase() + "%"));
    }
    return predicates.toArray(new Predicate[predicates.size()]);
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<Raca> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorDia = pageable.getPageSize();
    int primeiroRegristrosPorPagina = paginaAtual * totalRegistrosPorDia;

    query.setFirstResult(primeiroRegristrosPorPagina);
    query.setMaxResults(totalRegistrosPorDia);
  }

  private Long total(RacaFilter racaFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Raca> root = criteria.from(Raca.class);

    Predicate[] predicates = CriarRestricoes(racaFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("DescricaoRa")));

    criteria.select(builder.count(root));

    return  manager.createQuery(criteria). getSingleResult();
  }

}
