package com.projet.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Pack")
public class Pack {
	@Id 
	@GeneratedValue (strategy = GenerationType. IDENTITY)
	private Long idPack;
	
	@Column
	private String name;
	private Integer duree;
	private Integer price;
	
	@ManyToOne
	@JoinColumn (name = "idPlan")
	private Plan plan;
	
	@OneToMany (mappedBy = "pack")
	private Set<Client> clients;
}
