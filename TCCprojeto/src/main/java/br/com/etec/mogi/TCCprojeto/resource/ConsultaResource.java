package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Consulta;
import br.com.etec.mogi.TCCprojeto.repository.ConsultaRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.ConsultaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.ConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consulta")


public class ConsultaResource {

  @Autowired
  private ConsultaRepository consultaRepository;

  @GetMapping("/todos")
  public List<Consulta> listarTodasconsultas(){ return consultaRepository.findAll(); }

  @GetMapping()
public Page<ConsultaDTO> pesquisar (ConsultaFilter consultaFilter, Pageable pageable){
    return consultaRepository.Filtrar(consultaFilter,pageable);
  }
}
