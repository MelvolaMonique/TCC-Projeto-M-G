package br.com.etec.mogi.TCCprojeto.resource;


import br.com.etec.mogi.TCCprojeto.model.Cidade;
import br.com.etec.mogi.TCCprojeto.repository.CidadeRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.CidadeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")

public class CidadeResource {

  @Autowired
  private CidadeRepository cidadeRepository;

  @GetMapping()
  public Page<Cidade> pesquisar(CidadeFilter cidadeFilter, Pageable pageable) {
    return cidadeRepository.filtrar(cidadeFilter, pageable);
  }

  @GetMapping("/todos")
  public List<Cidade> listartodascidades() {
    return cidadeRepository.findAll();
  }


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id) {cidadeRepository.deleteById(id);
  }
  @PutMapping("/mudar-cidade/{id}")
  public HttpStatus mudagem(@PathVariable Integer id, @RequestBody Cidade cidadeRequest){
    return cidadeRepository.findById(id).map(
      cidade -> {
        cidade.setEstado(cidadeRequest.getEstado());
        cidade.setNomecidade(cidadeRequest.getNomecidade());

        cidadeRepository.save(cidade);
        return HttpStatus.OK;
      }

    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;
    });
  }
  @PostMapping()
  public ResponseEntity<Cidade> criar(@RequestBody Cidade cidade){

    return new ResponseEntity<>(cidadeRepository.save(cidade),HttpStatus.CREATED);
}
}
