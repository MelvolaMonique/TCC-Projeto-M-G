package br.com.etec.mogi.TCCprojeto.repository;

import br.com.etec.mogi.TCCprojeto.model.Especie;
import br.com.etec.mogi.TCCprojeto.repository.especie.EspecieRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Integer>, EspecieRepositoryQuery {
}
