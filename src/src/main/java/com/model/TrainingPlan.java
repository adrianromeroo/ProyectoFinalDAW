package com.model;

import java.util.Collection;
import java.util.Set;

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
@Table(name = "trainingplan")
public class TrainingPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "objetive")
	private String objetive;
	
	@Column(name = "price")
	private String price;

	@ManyToMany(mappedBy = "trainingplans", cascade = CascadeType.PERSIST)
	private Set<Routine> routines;
	
	@ManyToMany(mappedBy = "trainingplans", cascade = CascadeType.PERSIST)
	private Set<Diet> diets;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "trainingplan_user",					
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(					
							name = "trainingplan_id", referencedColumnName = "id"))
	private Collection<User> users;

	public TrainingPlan() {
		
	}

	public TrainingPlan(String name, String objetive, String price, Set<Routine> routines,
			Set<Diet> diets, Collection<User> users) {
		super();
		this.name = name;
		this.objetive = objetive;
		this.price = price;
		this.routines = routines;
		this.diets = diets;
		this.users = users;
	}

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

	public String getObjetive() {
		return objetive;
	}

	public void setObjetive(String objetive) {
		this.objetive = objetive;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Set<Routine> getRoutines() {
		return routines;
	}

	public void setRoutines(Set<Routine> routines) {
		this.routines = routines;
	}

	public Set<Diet> getDiets() {
		return diets;
	}

	public void setDiets(Set<Diet> diets) {
		this.diets = diets;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
}
