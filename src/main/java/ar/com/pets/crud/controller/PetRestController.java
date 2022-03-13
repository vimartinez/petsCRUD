package ar.com.pets.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.pets.crud.model.Pet;
import ar.com.pets.crud.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetRestController {
	@Autowired
	private PetService petService;
	
	@GetMapping(value="/", produces="Application/json")
	public @ResponseBody List<Pet> getAllPets(){
		return petService.getAllPets();
	}
	
	@GetMapping(value="/{id}", produces="Application/json")
	public @ResponseBody Optional<Pet> getPetById(@PathVariable("id") Integer id){
		return petService.getPetById(id);
	}
	
	@GetMapping(value="/name", produces="Application/json")
	public @ResponseBody Iterable<Pet> getPetByName(@RequestParam("name") String name){
		return petService.getPetByName(name);
	}
	
	@GetMapping(value="/nameandhealth", produces="Application/json")
	public @ResponseBody Iterable<Pet> getPetByNameAndHealth(@RequestParam("name") String name, @RequestParam("health") Integer health){
		return petService.getPetByNameAndHealth(name, health);
	}
	
	@GetMapping(value="/getSickPets", produces="Application/json")
	public @ResponseBody Iterable<Pet> getSickPets(){
		return petService.getSickPets();
	}
	
	@PostMapping(path = "/", produces = "application/json")
	public @ResponseBody Pet addPet(@RequestBody Pet pet) {
		return petService.addPet(pet);
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public @ResponseBody String delPet(@PathVariable("id") Integer id) {
		return petService.delPet(id);
	}
	
	@PutMapping(path = "/", produces = "application/json")
	public @ResponseBody Pet updPet(@RequestBody Pet pet) {
		return petService.updPet(pet);
	}

}
