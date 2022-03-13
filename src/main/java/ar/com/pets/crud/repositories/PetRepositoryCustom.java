package ar.com.pets.crud.repositories;

import ar.com.pets.crud.model.Pet;

public interface PetRepositoryCustom {
	
	Iterable <Pet> getPetByName(String name);
	
	Iterable <Pet> getPetByNameAndHealth(String name, Integer health);

}
