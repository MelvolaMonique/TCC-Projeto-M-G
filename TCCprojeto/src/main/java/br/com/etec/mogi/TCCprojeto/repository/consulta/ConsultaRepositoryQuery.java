package br.com.etec.mogi.TCCprojeto.repository.consulta;


import br.com.etec.mogi.TCCprojeto.repository.filter.ConsultaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.ConsultaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsultaRepositoryQuery {
  public Page <ConsultaDTO> Filtrar(ConsultaFilter consultaFilter, Pageable pageable);
}
