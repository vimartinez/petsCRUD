package ar.com.pets.crud.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ar.com.pets.crud.model.Pet;

public class PetRepositoryCustomImpl implements PetRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Iterable<Pet> getPetByName(String name) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pet> query = cb.createQuery(Pet.class);
		Root<Pet> root = query.from(Pet.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.like(root.get("name"), "%"+name+"%"));
		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Iterable<Pet> getPetByNameAndHealth(String name, Integer health) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pet> query = cb.createQuery(Pet.class);
		Root<Pet> root = query.from(Pet.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.and(cb.like(root.get("name"), "%"+name+"%")));
		predicates.add(cb.and(cb.equal(root.get("health"), health)));
		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		
		return entityManager.createQuery(query).getResultList();
	}

}
