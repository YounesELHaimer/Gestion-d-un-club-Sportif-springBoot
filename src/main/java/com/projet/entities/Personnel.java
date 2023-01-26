/**
 * 
 */
package com.projet.entities;

import java.sql.Date;
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
@Table(name="Personnel")
public class Personnel {
	
	@Id 
	@GeneratedValue (strategy = GenerationType. IDENTITY)
	private Long idPersonnel;
	
	@Column (name="firstName")
	private String firstName;
	private String lastName;
	private Date date;
	private String adresse;
	private Long phone;
	private String email;
	private Integer salary;
	
	@ManyToOne
	@JoinColumn (name="idJob")
	private Job job;
	
	@OneToMany (mappedBy = "personnel")
	private Set<Admin> admins;

	public Personnel(Long idPersonnel, String username, String firstName, String lastName, Date date, String adresse,
			Long phone, String email, Integer salary, Job job, Set<Admin> admins) {
		super();
		this.idPersonnel = idPersonnel;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
		this.job = job;
		this.admins = admins;
	}

	public Personnel() {
		super();
	}
	
	
}