package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Agenda;
import br.com.etec.mogi.TCCprojeto.model.Especie;
import br.com.etec.mogi.TCCprojeto.repository.EspecieRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.EspecieFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id){especieRepository.deleteById(id);}

  @PutMapping("/mmudar-especie/{id}")
  public HttpStatus mudaragem(@PathVariable Integer id, @RequestBody Especie especieRequest){
    return especieRepository.findById(id).map(
      especie -> {
        especie.setDescricaoEs(especieRequest.getDescricaoEs());

        especieRepository.save(especie);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });
  }
  @PostMapping()
  public ResponseEntity<Especie> criar(@RequestBody Especie especie){

    return new ResponseEntity<>(especieRepository.save(especie),HttpStatus.CREATED);
  }
}
