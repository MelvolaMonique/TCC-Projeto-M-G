package br.com.etec.mogi.TCCprojeto.repository.cliente;

import br.com.etec.mogi.TCCprojeto.repository.filter.ClienteFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
  public Page<ClienteDTO> Filtrar (ClienteFilter clienteFilter, Pageable pageable);
}
