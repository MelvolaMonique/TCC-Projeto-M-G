package br.com.etec.mogi.TCCprojeto.resource;

import br.com.etec.mogi.TCCprojeto.model.Animal;
import br.com.etec.mogi.TCCprojeto.repository.AnimalRepository;
import br.com.etec.mogi.TCCprojeto.repository.filter.AnimalFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.AnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
