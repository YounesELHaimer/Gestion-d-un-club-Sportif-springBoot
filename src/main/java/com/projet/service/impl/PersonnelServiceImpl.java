package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.entities.Personnel;
import com.projet.repo.PersonnelRepository;
import com.projet.service.PersonnelService;



@Service
public class PersonnelServiceImpl implements PersonnelService {
	
	@Autowired
	private PersonnelRepository er; 
	@Override
	public List<Personnel> getAllPers() {
		
		return er.findAll();
	}
	@Override
	public Personnel savePers(Personnel emp) {
		
		return er.save(emp);
	}
	@Override
	public Personnel getPersonnelById(Long id) {
		
		return er.findById(id).get();
	}
	@Override
	public void updatePersonnel(Personnel s) {
		// TODO Auto-generated method stub
		er.save(s);
	}
	@Override
	public void deletePersonnelById(Long id) {
		er.deleteById(id);
		
	}
	
	
	

}
