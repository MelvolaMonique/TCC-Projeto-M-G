package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Especie;
import br.com.etec.mogi.TCCprojeto.repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especies")

public class EspecieResource {


  @Autowired
  private EspecieRepository especieRepository;

  @GetMapping("/todos")
  public List<Especie> listarTodasEspecies(){ return especieRepository.findAll(); }

}
