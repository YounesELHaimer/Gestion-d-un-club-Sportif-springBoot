package com.projet.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.projet.entities.Admin;
import com.projet.entities.Personnel;
import com.projet.repo.PersonnelRepository;
import com.projet.repo.adminRepository;
import com.projet.service.PersonnelService;


@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	adminRepository arepo;
	
	@Autowired
	private PersonnelRepository dao;
	

	@RequestMapping("/sidebar")
	public String ho()
	{
		return "sidebar";
	} 
	
	@RequestMapping("/login")
	public String home()
	{
		return "login";
	} 
	@PostMapping("/Personnel")
	public String login(Model m,@RequestParam("name") String username,@RequestParam("password") String password)
	{
		    
	Admin auser=arepo.findByUsernamePassword(username, password);
	
	if(auser!=null)
	{
		String uname=auser.getUsername();
		String upass=auser.getPassword();
	
		if(username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) 
		{
			
			return "redirect:/Personnel";
		}
		else  
		{
			
			return "redirect:/login";
		}
	}
	else
	{ 
		
		return "redirect:/login";
	}
	
	}
	
	@Autowired
	private PersonnelService ss;
	
	@GetMapping("/Personnel")
	public String listPersonnel(Model m ) {
		m.addAttribute("badr",dao.findAll());
		return "Personnel";
	}
	
	@GetMapping("/Personnel/new")
	
	public String createPersonnelForm(Model m) {
		Personnel e = new Personnel();
		m.addAttribute("Personnel",e);
		return "create_Personnel";
		
		
	} 
	
 	
	
	@PostMapping("/Personnel/add")
	public String savePersonnel(@ModelAttribute("Personnel") Personnel Personnel) {
		ss.savePers(Personnel);
		return "redirect:/Personnel";
	}
	@GetMapping("/Personnel/edit/{id}")
	
	public String updatePersonnelForm(@PathVariable Long id,Model m) {
		Personnel e =  ss.getPersonnelById(id);
		m.addAttribute("Personnel",e);
		return "edit_Personnel";
		
		 
	} 
	@PostMapping("/Personnel/{id}")
	public String updatePersonnel(@PathVariable Long id,@ModelAttribute("Personnel") Personnel Personnel) {
		// get student from db by id
		
		Personnel s  = ss.getPersonnelById(id);
		s.setIdPersonnel(id);
		s.setFirstName(Personnel.getFirstName());
		s.setLastName(Personnel.getLastName());
		s.setAdresse(Personnel.getAdresse());
		s.setDate(Personnel.getDate());
		s.setPhone(Personnel.getPhone());
		s.setEmail(Personnel.getEmail());
		s.setSalary(Personnel.getSalary());
		
 		// save updated student object
		ss.updatePersonnel(s); 
		return "redirect:/Personnel";
		 
	}
	
	@GetMapping("/Personnel/{id}")
	public String deletePersonnel(@PathVariable Long id) {
		ss.deletePersonnelById(id);
		return "redirect:/Personnel";
}

	 
	 
}
