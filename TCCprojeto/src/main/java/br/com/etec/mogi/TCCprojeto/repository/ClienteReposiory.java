package br.com.etec.mogi.TCCprojeto.repository;

import br.com.etec.mogi.TCCprojeto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteReposiory extends JpaRepository<Cliente, Integer> {
}
