package br.com.etec.mogi.TCCprojeto.repository.medico;

import br.com.etec.mogi.TCCprojeto.repository.filter.MedicoFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.MedicoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoRepositoryQuery {

  public Page<MedicoDTO> Filtrar (MedicoFilter medicoFilter, Pageable pageable);
}
