package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Consulta;
import br.com.etec.mogi.TCCprojeto.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
