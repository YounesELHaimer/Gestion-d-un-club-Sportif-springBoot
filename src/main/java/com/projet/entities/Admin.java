package com.projet.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	
	@Id 
	@GeneratedValue (strategy = GenerationType. IDENTITY)
	private Long idAdmin;
	
	@Column (name="username")
	private String username;
	private String password;

	@ManyToOne
	@JoinColumn (name="idPersonnel")
	private Personnel personnel;

	
	
}
