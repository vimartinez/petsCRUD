package ar.com.pets.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="mascotas")
public class Pet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "El nombre de la mascota no puede ser nulo")
	private String name;
	@Range(min=1,max=100, message="La salud debe estar entre 0 y 100")
	private Integer health;
	private String type;
	
	
	public Pet() {
		
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getHealth() {
		return health;
	}


	public void setHealth(Integer health) {
		this.health = health;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
