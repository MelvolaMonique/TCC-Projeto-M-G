package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Cidade;
import br.com.etec.mogi.TCCprojeto.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidade")

public class CidadeResource {

  @Autowired
  private CidadeRepository cidadeRepository;

  @GetMapping("/todos")
  public List<Cidade> listartodascidades(){
    return  cidadeRepository.findAll();
  }

}
