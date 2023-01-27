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
	
	@Column (name="username")
	private String username;
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

	public Client(Long idClient, String username, String firstName, String lastName, Date date, String adresse,
			Long phone, String email, boolean hasPaid, Date datePayment, Pack pack, WorkTime workTime) {
		super();
		this.idClient = idClient;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;
		this.hasPaid = hasPaid;
		this.datePayment = datePayment;
		this.pack = pack;
		this.workTime = workTime;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isHasPaid() {
		return hasPaid;
	}

	public void setHasPaid(boolean hasPaid) {
		this.hasPaid = hasPaid;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public WorkTime getWorkTime() {
		return workTime;
	}

	public void setWorkTime(WorkTime workTime) {
		this.workTime = workTime;
	}
	
	

	
}
