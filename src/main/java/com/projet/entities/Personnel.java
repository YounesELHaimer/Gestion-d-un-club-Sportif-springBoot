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

	public Long getIdPersonnel() {
		return idPersonnel;
	}

	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Set<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
	}

	@Override
	public String toString() {
		return "Personnel [idPersonnel=" + idPersonnel + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", date=" + date + ", adresse=" + adresse + ", phone=" + phone + ", email=" + email + ", salary="
				+ salary + ", job=" + job + ", admins=" + admins + "]";
	}
	
	
	
}