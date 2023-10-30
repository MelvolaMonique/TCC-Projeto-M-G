package br.com.etec.mogi.TCCprojeto.repository.animal;

import br.com.etec.mogi.TCCprojeto.model.Animal;
import br.com.etec.mogi.TCCprojeto.repository.filter.AnimalFilter;

import br.com.etec.mogi.TCCprojeto.repository.projections.AnimalDTO;
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



public class AnimalRepositoryImpl implements AnimalRepositoryQuery  {
@PersistenceContext
  private EntityManager manager;

@Override
  public Page<AnimalDTO> filtrar(AnimalFilter animalFilter, Pageable pageable){

  CriteriaBuilder builder = manager.getCriteriaBuilder();
  CriteriaQuery<AnimalDTO> criteria = builder.createQuery(AnimalDTO.class);
  Root<Animal> root = criteria.from(Animal.class);

  criteria.select(builder.construct(AnimalDTO.class
  ,root.get("id")
  ,root.get("nomeanimal")
  ,root.get("idade")
  ,root.get("sexo")
  ,root.get("castracao")
  ,root.get("raca").get("descricaoRa")
  ,root.get("especie").get("descricaoEs")
  ,root.get("cliente").get("nomecliente")));

  Predicate[] predicates =CriarRestricoes(animalFilter, builder, root);
  criteria.where(predicates);
  criteria.orderBy(builder.asc(root.get("nomeanimal")));

  TypedQuery<AnimalDTO> query = manager.createQuery(criteria);
  adicionarRestricoesDePaginacao(query, pageable);

  return new PageImpl<>(query.getResultList(), pageable, total(animalFilter));
}

  private void adicionarRestricoesDePaginacao(TypedQuery<AnimalDTO> query, Pageable pageable) {
  int paginaAtual = pageable.getPageNumber();
  int totalRegistrosPorDia = pageable.getPageSize();
  int primeiroRegistrosPorPagina = paginaAtual * totalRegistrosPorDia;

  query.setFirstResult(primeiroRegistrosPorPagina);
  query.setMaxResults(totalRegistrosPorDia);

}
  private Long total(AnimalFilter animalFilter) {
  CriteriaBuilder builder = manager.getCriteriaBuilder();
  CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
  Root<Animal> root = criteria.from(Animal.class);

    Predicate[] predicates = CriarRestricoes(animalFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomeanimal")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();

  }
  private Predicate[] CriarRestricoes(AnimalFilter animalFilter, CriteriaBuilder builder, Root<Animal> root) {
    List<Predicate> predicates = new ArrayList<>();
    if (!StringUtils.isEmpty(animalFilter.getNomeanimal())){
      predicates.add(builder.like(builder.lower(root.get("nomeanimal")),
        "%" + animalFilter.getNomeanimal().toLowerCase() + "%"));
    }
    if (!StringUtils.isEmpty(animalFilter.getIdade())){
      predicates.add(builder.like(builder.lower(root.get("idade")),
        "%" + animalFilter.getIdade().toLowerCase() + "%"));
    }
    if (!StringUtils.isEmpty(animalFilter.getSexo())){
      predicates.add(builder.like(builder.lower(root.get("sexo")),
        "%" + animalFilter.getSexo().toLowerCase() + "%"));
    }
    if (!StringUtils.isEmpty(animalFilter.getCastracao())){
      predicates.add(builder.like(builder.lower(root.get("castração")),
        "%" + animalFilter.getCastracao().toLowerCase() + "%"));
    }
    if (!StringUtils.isEmpty(animalFilter.getDescricaoRa())){
      predicates.add(builder.equal(builder.lower(root.get("raca").get("descricãora")),
        animalFilter.getDescricaoRa().toLowerCase()));
    }
    if (!StringUtils.isEmpty(animalFilter.getDescricaoEs())){
      predicates.add(builder.equal(builder.lower(root.get("especie").get("descricãoes")),
        animalFilter.getDescricaoRa().toLowerCase()));
    }
    if (!StringUtils.isEmpty(animalFilter.getNomecliente())){
      predicates.add(builder.equal(builder.lower(root.get("cliente").get("nomecliente")),
        animalFilter.getNomecliente().toLowerCase()));
    }

    return predicates.toArray(new Predicate[predicates.size()]);
  }


}

