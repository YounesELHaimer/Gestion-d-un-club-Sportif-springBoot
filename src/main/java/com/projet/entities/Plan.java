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
	
	
	@OneToMany (mappedBy = "plan")
	private Set<Pack> packs;


}
