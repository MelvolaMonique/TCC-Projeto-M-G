package br.com.etec.mogi.TCCprojeto.repository;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer > {
}
