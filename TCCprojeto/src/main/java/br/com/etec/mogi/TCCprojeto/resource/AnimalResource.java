package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Animal;
import br.com.etec.mogi.TCCprojeto.repository.AnimalRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.AnimalFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalResource {

  @Autowired
  private AnimalRepository animalRepository;

  @GetMapping("/todos")
  public List<Animal> listartodosanimais(){
    return animalRepository.findAll();
  }

  @GetMapping()
  public Page<AnimalDTO> pesquisar (AnimalFilter animalFilter, Pageable pageable){
    return animalRepository.filtrar(animalFilter, pageable);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer id){
    animalRepository.deleteById(id);
  }
  @PutMapping("/mudar-animal/{id}")
  public HttpStatus mudaragem(@PathVariable Integer id, @RequestBody Animal animalRequest) {
    return animalRepository.findById(id).map(
      animal -> {
        animal.setNomeanimal(animalRequest.getNomeanimal());
        animal.setIdade(animalRequest.getIdade());
        animal.setSexo(animalRequest.getSexo());
        animal.setCastracao(animalRequest.getCastracao());

        animalRepository.save(animal);
        return HttpStatus.OK;
      }
    ).orElseGet(() -> {
      return HttpStatus.NOT_FOUND;

    });
  }
  @PostMapping()
  public ResponseEntity<Animal> criar(@RequestBody Animal animal){

    return new ResponseEntity<>(animalRepository.save(animal),HttpStatus.CREATED);
  }

}
