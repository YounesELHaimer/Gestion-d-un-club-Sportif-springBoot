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

	public Admin(Long idAdmin, String username, String password, Personnel personnel) {
		super();
		this.idAdmin = idAdmin;
		this.username = username;
		this.password = password;
		this.personnel = personnel;
	}

	public Admin() {
		super();
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	
	

	
	
}
