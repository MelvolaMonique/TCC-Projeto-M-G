package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.model.Medico;
import br.com.etec.mogi.TCCprojeto.repository.MedicoRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.MedicoFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {

  @Autowired
  private MedicoRepository medicoRepository;

  @GetMapping("/todos")
  public List<Medico> listarTodosMedicos(){ return medicoRepository.findAll(); }

  @GetMapping()
  public Page<MedicoDTO> pesquisar (MedicoFilter medicoFilter, Pageable pageable){
    return medicoRepository.Filtrar(medicoFilter, pageable);
  }
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id){medicoRepository.deleteById(id);}

  @PutMapping("/mudar-medico/{id}")
  public HttpStatus mudaragem(@PathVariable Integer id, @RequestBody Medico medicoRequest){
    return medicoRepository.findById(id).map(
      medico -> {
        medico.setNomemedico(medicoRequest.getNomemedico());
        medico.setTelefone(medicoRequest.getTelefone());
        medico.setCPF(medicoRequest.getCPF());
        medico.setRG(medicoRequest.getRG());

        medicoRepository.save(medico);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });
  }
  @PostMapping()
  public ResponseEntity<Medico> criar(@RequestBody Medico medico){

    return new ResponseEntity<>(medicoRepository.save(medico),HttpStatus.CREATED);
  }

}

