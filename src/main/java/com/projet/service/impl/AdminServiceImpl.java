package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.entities.Admin;

import com.projet.repo.adminRepository;
import com.projet.service.AdminService;



@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private adminRepository er; 
	@Override
	public List<Admin> getAllPers() {
		
		return er.findAll();
	}
	@Override
	public Admin savePers(Admin emp) {
		
		return er.save(emp);
	}
	@Override
	public Admin getAdminById(Long id) {
		
		return er.findById(id).get();
	}
	@Override
	public void updateAdmin(Admin s) {
		// TODO Auto-generated method stub
		er.save(s);
	}
	@Override
	public void deleteAdminById(Long id) {
		er.deleteById(id);
		
	}
	
	
	

}
