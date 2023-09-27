package br.com.etec.mogi.TCCprojeto.repository.cidade;

import br.com.etec.mogi.TCCprojeto.model.Cidade;
import br.com.etec.mogi.TCCprojeto.repository.filter.CidadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadeRepositoryQuery {
  public Page<Cidade> filtrar(CidadeFilter cidadeFilter, Pageable pageable);
}
