package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Usuario;
import br.com.etec.mogi.TCCprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")

public class UsuarioResource {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping("/todos")
  public List<Usuario> listarTodosusuarios(){ return usuarioRepository.findAll(); }

}
