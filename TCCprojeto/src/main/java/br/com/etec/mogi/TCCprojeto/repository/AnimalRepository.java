package br.com.etec.mogi.TCCprojeto.repository;

import br.com.etec.mogi.TCCprojeto.model.Animal;
import br.com.etec.mogi.TCCprojeto.repository.animal.AnimalRepositoryImpl;
import br.com.etec.mogi.TCCprojeto.repository.animal.AnimalRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> , AnimalRepositoryQuery{
}
