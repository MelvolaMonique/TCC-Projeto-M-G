package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Medico;
import br.com.etec.mogi.TCCprojeto.repository.MedicoRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.MedicoFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {

  @Autowired
  private MedicoRepository medicoRepository;

  @GetMapping("/todos")
  public List<Medico> listarTodosMedicos(){ return medicoRepository.findAll(); }

  @GetMapping()
  public Page<MedicoDTO> pesquisar (MedicoFilter medicoFilter, Pageable pageable){
    return medicoRepository.Filtrar(medicoFilter, pageable);
  }
}

