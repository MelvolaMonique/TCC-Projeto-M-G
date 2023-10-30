package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Raca;
import br.com.etec.mogi.TCCprojeto.repository.RacaRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.RacaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaResource {

  @Autowired
  private RacaRepository racaRepository;

  @GetMapping()
  public Page<Raca> pesquisar(RacaFilter racaFilter, Pageable pageable){
    return racaRepository.filtrar(racaFilter, pageable);
  }

  @GetMapping("/todos")
  public List<Raca> listarTodasracas(){ return racaRepository.findAll(); }


}
