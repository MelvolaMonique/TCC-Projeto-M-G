package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Medico;
import br.com.etec.mogi.TCCprojeto.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Medicos")
public class MedicoResource {

  @Autowired
  private MedicoRepository medicoRepository;

  @GetMapping("/todos")
  public List<Medico> listarTodosMedicos(){ return medicoRepository.findAll(); }

}
