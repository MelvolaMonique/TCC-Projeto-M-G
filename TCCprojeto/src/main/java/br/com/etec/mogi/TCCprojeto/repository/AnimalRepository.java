package br.com.etec.mogi.TCCprojeto.repository;

import br.com.etec.mogi.TCCprojeto.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
