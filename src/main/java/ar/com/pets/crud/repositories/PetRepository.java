package ar.com.pets.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.com.pets.crud.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>, PetRepositoryCustom {
	
	@Query(value = "SELECT * FROM MASCOTAS m WHERE m.health < 50", nativeQuery = true)
	Iterable<Pet> getSickPets();

}
