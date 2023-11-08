package br.com.etec.mogi.TCCprojeto.service;

import br.com.etec.mogi.TCCprojeto.model.Animal;
import br.com.etec.mogi.TCCprojeto.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AnimalService {
  @Autowired
  private AnimalRepository animalRepository;

  public Animal salvar (Animal animal) {
    return animalRepository.save(animal);
  }
  public Animal atualizar(Integer id, Animal animal) throws IllegalAccessException {
    Animal animalsalva = busanimalexistente(id);
    return animalRepository.save(animalsalva);
  }
  private Animal busanimalexistente(Integer id) throws IllegalAccessException {
    Optional<Animal> animalsalva=animalRepository.findById(id);
    if (!animalsalva.isPresent()){
      throw new IllegalAccessException();
    }
  return animalsalva.get();
  }
}
