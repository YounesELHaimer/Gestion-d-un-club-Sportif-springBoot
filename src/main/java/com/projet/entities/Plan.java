package com.projet.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Plan")
public class Plan {
	@Id 
	@GeneratedValue (strategy = GenerationType. IDENTITY)
	private Long idPlan;
	
	@Column (name="name")
	private String name;
	
	
	
	public Plan(Long idPlan, String name, Set<Pack> packs) {
		super();
		this.idPlan = idPlan;
		this.name = name;
		this.packs = packs;
	}



	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}



	@OneToMany (mappedBy = "plan")
	private Set<Pack> packs;



	public Long getIdPlan() {
		return idPlan;
	}



	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<Pack> getPacks() {
		return packs;
	}



	public void setPacks(Set<Pack> packs) {
		this.packs = packs;
	}

}
