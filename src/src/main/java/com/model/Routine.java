package com.model;

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

@Entity
@Table(name = "routine")
public class Routine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "intensity")
	private String intensity;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "trainingplan_routine",					
			joinColumns = @JoinColumn(
					name = "routine_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(					
							name = "trainingplan_id", referencedColumnName = "id"))	
	private Set<TrainingPlan> trainingplans;
	
	public Routine(String name, String intensity, Set<TrainingPlan> trainingplans) {
		super();
		this.name = name;
		this.intensity = intensity;
		this.trainingplans = trainingplans;
	}

	public Routine() {
		
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

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public Set<TrainingPlan> getTrainingplans() {
		return trainingplans;
	}

	public void setTrainingplans(Set<TrainingPlan> trainingplans) {
		this.trainingplans = trainingplans;
	}	
}
