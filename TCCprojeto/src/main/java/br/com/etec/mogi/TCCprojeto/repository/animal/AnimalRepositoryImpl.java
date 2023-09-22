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

public class AnimalRepositoryImpl  {
}
