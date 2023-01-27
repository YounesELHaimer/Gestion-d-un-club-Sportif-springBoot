package com.projet.entities;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="WorkTime")
public class WorkTime {
	
	@Id 
	@GeneratedValue (strategy = GenerationType. IDENTITY)
	private Long idWorkTime;
	
	@Column
	private String dayOne;
	private String dayTwo;
	private String dayThree;
	
	@OneToMany(mappedBy = "workTime")
	private Set<Client> clients;

	public Long getIdWorkTime() {
		return idWorkTime;
	}

	public void setIdWorkTime(Long idWorkTime) {
		this.idWorkTime = idWorkTime;
	}

	public String getDayOne() {
		return dayOne;
	}

	public void setDayOne(String dayOne) {
		this.dayOne = dayOne;
	}

	public String getDayTwo() {
		return dayTwo;
	}

	public void setDayTwo(String dayTwo) {
		this.dayTwo = dayTwo;
	}

	public String getDayThree() {
		return dayThree;
	}

	public void setDayThree(String dayThree) {
		this.dayThree = dayThree;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
}
