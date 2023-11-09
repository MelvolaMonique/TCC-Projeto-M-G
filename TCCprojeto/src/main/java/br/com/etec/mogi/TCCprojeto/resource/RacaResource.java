package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Raca;
import br.com.etec.mogi.TCCprojeto.repository.RacaRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.RacaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaResource {

  @Autowired
  private RacaRepository racaRepository;

  @GetMapping()
  public Page<Raca> pesquisar(RacaFilter racaFilter, Pageable pageable){
    return racaRepository.filtrar(racaFilter, pageable);
  }

  @GetMapping("/todos")
  public List<Raca> listarTodasracas(){ return racaRepository.findAll(); }


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id){racaRepository.deleteById(id);}

  @PutMapping("/mudar-raca/{id}")
  public HttpStatus mudaragem(@PathVariable Integer id, @RequestBody Raca racaRequest){
    return racaRepository.findById(id).map(
      raca -> {
        raca.setDescricaoRa(racaRequest.getDescricaoRa());

        racaRepository.save(raca);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });
  }
  @PostMapping()
  public ResponseEntity<Raca> criar(@RequestBody Raca raca){

    return new ResponseEntity<>(racaRepository.save(raca),HttpStatus.CREATED);
  }
}
