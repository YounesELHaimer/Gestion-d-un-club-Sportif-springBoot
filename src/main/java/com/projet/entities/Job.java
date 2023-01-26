package com.projet.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Job")
public class Job {
	
	@Id 
	@GeneratedValue (strategy = GenerationType. IDENTITY)
	private Long idJob;
	
	@Column
	private String title;
	
	@OneToMany (mappedBy = "job")
	private Set<Personnel> personnels;
	
}
