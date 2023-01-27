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
	public Long getIdPack() {
		return idPack;
	}

	public void setIdPack(Long idPack) {
		this.idPack = idPack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	private Integer price;
	
	@ManyToOne
	@JoinColumn (name = "idPlan")
	private Plan plan;
	
	@OneToMany (mappedBy = "pack")
	private Set<Client> clients;
	
	
}
