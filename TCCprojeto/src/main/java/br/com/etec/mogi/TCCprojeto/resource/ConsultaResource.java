package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.model.Consulta;
import br.com.etec.mogi.TCCprojeto.repository.ConsultaRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.ConsultaFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.ConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")


public class ConsultaResource {

  @Autowired
  private ConsultaRepository consultaRepository;

  @GetMapping("/todos")
  public List<Consulta> listarTodasconsultas(){ return consultaRepository.findAll(); }

  @GetMapping()
public Page<ConsultaDTO> pesquisar (ConsultaFilter consultaFilter, Pageable pageable){
    return consultaRepository.Filtrar(consultaFilter,pageable);
  }
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id){consultaRepository.deleteById(id);}


  @PutMapping("/mudar-consulta/{id}")
  public HttpStatus mudaragem(@PathVariable Integer id, @RequestBody Consulta consultaRequest){
    return consultaRepository.findById(id).map(
      consulta -> {
        consulta.setDatahoraconsulta(consultaRequest.getDatahoraconsulta());
        consulta.setHistorico(consultaRequest.getHistorico());

        consultaRepository.save(consulta);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });
  }
  @PostMapping()
  public ResponseEntity<Consulta> criar(@RequestBody Consulta consulta){

    return new ResponseEntity<>(consultaRepository.save(consulta),HttpStatus.CREATED);
  }
}
