package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Raca;
import br.com.etec.mogi.TCCprojeto.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class RacaResource {

  @Autowired
  private RacaRepository racaRepository;

  @GetMapping("/todos")
  public List<Raca> listarTodasracas(){ return racaRepository.findAll(); }


}
