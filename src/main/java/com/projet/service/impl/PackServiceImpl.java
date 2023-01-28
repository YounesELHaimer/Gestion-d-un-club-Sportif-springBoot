package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.entities.Pack;
import com.projet.repo.packRepository;
import com.projet.service.PackService;



@Service
public class PackServiceImpl implements PackService {
	
	@Autowired
	private packRepository er; 
	@Override
	public List<Pack> getAllPers() {
		
		return er.findAll();
	}
	@Override
	public Pack savePers(Pack emp) {
		
		return er.save(emp);
	}
	@Override
	public Pack getPackById(Long id) {
		
		return er.findById(id).get();
	}
	@Override
	public void updatePack(Pack s) {
		// TODO Auto-generated method stub
		er.save(s);
	}
	@Override
	public void deletePackById(Long id) {
		er.deleteById(id);
		
	}
	
	
	

}
