package com.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;					
import javax.persistence.Entity;			
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "diet")
public class Diet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "fats")
	private int fats;
	
	@Column(name = "carbohydrates")
	private int carbohydrates;
	
	@Column(name = "proteins")
	private int proteins;
	
	@Column(name = "allergens")
	private String allergens;
	
	public Diet() {
		
	}

	public Diet(String name, String description, int fats, int carbohydrates, int proteins, String allergens) {
		super();
		this.name = name;
		this.description = description;
		this.fats = fats;
		this.carbohydrates = carbohydrates;
		this.proteins = proteins;
		this.allergens = allergens;
	}

	/* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",					
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(					
							name = "role_id", referencedColumnName = "id")) */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFats() {
		return fats;
	}

	public void setFats(int fats) {
		this.fats = fats;
	}

	public int getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(int carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public int getProteins() {
		return proteins;
	}

	public void setProteins(int proteins) {
		this.proteins = proteins;
	}

	public String getAllergens() {
		return allergens;
	}

	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}
	
}
