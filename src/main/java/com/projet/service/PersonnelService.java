package com.projet.service;

import java.util.List; 

import com.projet.entities.Personnel;



public interface PersonnelService {
	List<Personnel> getAllPers();
	
	Personnel savePers(Personnel emp);

	Personnel getPersonnelById(Long id);

	void updatePersonnel(Personnel s);

	void deletePersonnelById(Long id);
}
