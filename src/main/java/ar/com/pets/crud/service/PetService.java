package ar.com.pets.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.pets.crud.model.Pet;
import ar.com.pets.crud.repositories.PetRepository;

@Service
public class PetService {

	@Autowired
	PetRepository petRepository;
	
	public List<Pet> getAllPets (){
		return petRepository.findAll();
	}

	public Optional<Pet> getPetById(Integer id) {
		return petRepository.findById(id);
	}

	public Iterable<Pet> getPetByName(String name) {
		return petRepository.getPetByName(name);
	}

	public Pet addPet(Pet pet) {
		petRepository.save(pet);
		return pet;
	}

	public String delPet(Integer id) {
			Optional<Pet> pet = petRepository.findById(id);
		//			.orElseThrow(() -> new PetNotFoundException("Mascota id="+ Long.toString(id, 10) +", No se eliminó ningún registro"));
			petRepository.deleteById(id);
			return "Super Heroe eliminado";
		}
		
	public Pet updPet(Pet petNuevo) {
			Optional<Pet> optPet = petRepository.findById(petNuevo.getId());
			Pet petActual = optPet.get();
		//			.orElseThrow(() -> new PetNotFoundException( "Mascota id="+petNuevo.getId() + ", No se realizó la actualización"));
			petActual.setHealth(petNuevo.getHealth());
			petActual.setName(petNuevo.getName());
			petActual.setType(petNuevo.getType());
			return petRepository.save(petActual);
			
		}

	public Iterable<Pet> getPetByNameAndHealth(String name, Integer health) {
		return petRepository.getPetByNameAndHealth(name, health);
	}

	public Iterable<Pet> getSickPets() {
		return petRepository.getSickPets();
	}
}
