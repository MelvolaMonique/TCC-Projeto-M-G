package br.com.etec.mogi.TCCprojeto.repository;


import br.com.etec.mogi.TCCprojeto.model.Cliente;
import br.com.etec.mogi.TCCprojeto.repository.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryQuery {

}
