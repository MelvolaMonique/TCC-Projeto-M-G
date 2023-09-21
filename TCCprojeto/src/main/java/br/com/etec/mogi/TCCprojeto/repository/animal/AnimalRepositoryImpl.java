package br.com.etec.mogi.TCCprojeto.repository.animal;

import br.com.etec.mogi.TCCprojeto.model.Animal;
import br.com.etec.mogi.TCCprojeto.repository.filter.AnimalFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AnimalDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AnimalRepositoryImpl implements AnimalRepositoryQuery {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<AnimalDTO> filtrar(AnimalFilter animalFilter, Pageable pageable) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<AnimalDTO> criteria = builder.createQuery(AnimalDTO.class);
    Root<Animal> root = criteria.from(Animal.class);

    criteria.select(builder.construct(AnimalDTO.class
      , root.get("id")
      , root.get("nomeanimal")
      , root.get("idade")
      , root.get("sexo")
      , root.get("castracao")
      , root.get("raca").get("descricaoRa")
      , root.get("especie").get("descricaoEs")
      , root.get("cliente").get("nomecliente")
    ));
}
return null;
}
