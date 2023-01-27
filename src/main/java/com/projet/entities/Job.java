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

	public Long getIdJob() {
		return idJob;
	}

	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(Long idJob, String title, Set<Personnel> personnels) {
		super();
		this.idJob = idJob;
		this.title = title;
		this.personnels = personnels;
	}


}
