package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Especie;
import br.com.etec.mogi.TCCprojeto.repository.EspecieRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.EspecieFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especies")

public class EspecieResource {


  @Autowired
  private EspecieRepository especieRepository;

  @GetMapping()
  public Page<Especie> pesquisar(EspecieFilter especieFilter, Pageable pageable){
    return especieRepository.Filtrar(especieFilter, pageable);
  }

  @GetMapping("/todos")
  public List<Especie> listarTodasEspecies(){ return especieRepository.findAll(); }

}
