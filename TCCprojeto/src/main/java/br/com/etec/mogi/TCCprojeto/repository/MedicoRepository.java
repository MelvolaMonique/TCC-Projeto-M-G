package br.com.etec.mogi.TCCprojeto.repository;

import br.com.etec.mogi.TCCprojeto.model.Medico;
import br.com.etec.mogi.TCCprojeto.repository.medico.MedicoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer>, MedicoRepositoryQuery {
}
