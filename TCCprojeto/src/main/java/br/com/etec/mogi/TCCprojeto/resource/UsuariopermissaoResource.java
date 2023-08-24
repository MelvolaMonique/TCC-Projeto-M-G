package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Usuariopermissao;
import br.com.etec.mogi.TCCprojeto.repository.UsuariopermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuariopermissao")

public class UsuariopermissaoResource {

  @Autowired
  private UsuariopermissaoRepository usuariopermissaoRepository;
}
