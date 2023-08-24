package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Permissao;
import br.com.etec.mogi.TCCprojeto.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Permissoes")

public class PermissaoResource {
  @Autowired
  private PermissaoRepository permissaoRepository;

  @GetMapping("/todos")
  public List<Permissao> listarTodaspermissoes(){ return permissaoRepository.findAll(); }



}
