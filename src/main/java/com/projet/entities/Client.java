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
@Table(name="Client")
public class Client {
	
	@Id 
	@GeneratedValue (strategy = GenerationType. IDENTITY)
	private Long idClient;
	
	@Column (name="firstName")
	private String firstName;
	private String lastName;
	private Date date;
	private String adresse;
	private Long phone;
	private String email;
	private boolean hasPaid;
	private Date datePayment;
	
	@ManyToOne
	@JoinColumn (name="idPack")
	private Pack pack;
	
	@OneToOne
	@JoinColumn (name="id_WorkTime")
	private WorkTime workTime;
		
	public Client() {
		super();
	}

	
}
