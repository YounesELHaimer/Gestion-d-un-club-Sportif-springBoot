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
import com.projet.entities.Client;
import com.projet.entities.Job;
import com.projet.entities.Personnel;
import com.projet.repo.ClientRepository;
import com.projet.repo.PersonnelRepository;
import com.projet.repo.adminRepository;
import com.projet.repo.jobRepository;
import com.projet.repo.packRepository;
import com.projet.repo.worktimeRepository;
import com.projet.service.ClientService;
import com.projet.service.PersonnelService;


@org.springframework.stereotype.Controller
public class Controller {

	//####################################### Partie Login #######################################
	@Autowired
	adminRepository arepo;
	
	@Autowired
	private PersonnelRepository dao;
	
	@Autowired
	private ClientRepository dao2;
	

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
	
	//####################################### partie Personnel #######################################
	
	@Autowired
	private PersonnelService ss;
	@Autowired
	private jobRepository jR;
	
	@GetMapping("/Personnel")
	public String listPersonnel(Model m ) {
		
		m.addAttribute("badr",dao.findAll());
		return "Personnel";
	}
	
	@GetMapping("/Personnel/new")
	
	public String createPersonnelForm(Model m ) {
		m.addAttribute("jobs",jR.findAll());
	
		Personnel e = new Personnel();
		m.addAttribute("Personnel",e);
		return "create_Personnel";
		
		
	} 
	
 	
	
	@PostMapping("/Personnel/add")
	public String savePersonnel(@ModelAttribute("Personnel") Personnel Personnel ) {
		
		
		ss.savePers(Personnel);
		return "redirect:/Personnel";
	}
	@GetMapping("/Personnel/edit/{id}")
	
	public String updatePersonnelForm(@PathVariable Long id,Model m) {
		m.addAttribute("jobs",jR.findAll());
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
		s.setJob(Personnel.getJob());
		
 		// save updated student object
		ss.updatePersonnel(s); 
		return "redirect:/Personnel";
		 
	}
	
	@GetMapping("/Personnel/{id}")
	public String deletePersonnel(@PathVariable Long id) {
		ss.deletePersonnelById(id);
		return "redirect:/Personnel";
}
	
	//####################################### partie Client #######################################
	
		@Autowired
		private ClientService cs;
		
		@Autowired
		private packRepository pR;
		
		@Autowired
		private worktimeRepository wR;
		
		
		@GetMapping("/Client")
		public String listClient(Model m ) {
			m.addAttribute("badre",cs.getAllPers());
			return "Client";
		}
		
		@GetMapping("/Client/new")
		
		public String createClientForm(Model m) {
			m.addAttribute("packs",pR.findAll());
			m.addAttribute("worktimes",wR.findAll());
			Client e = new Client();
			m.addAttribute("Client",e);
			return "create_Client";
			
			
		} 
		
	 	
		
		@PostMapping("/Client/add")
		public String saveClient(@ModelAttribute("Client") Client Client) {
			cs.savePers(Client);
			return "redirect:/Client";
		}
		@GetMapping("/Client/edit/{id}")
		
		public String updateClientForm(@PathVariable Long id,Model m) {
			m.addAttribute("packs",pR.findAll());
			m.addAttribute("worktimes",wR.findAll());
			Client e =  cs.getClientById(id);
			m.addAttribute("Client",e);
			return "edit_Client";
			
			 
		} 
		@PostMapping("/Client/{id}")
		public String updateClient(@PathVariable Long id,@ModelAttribute("Client") Client Client) {
			// get student from db by id
			
			Client s  = cs.getClientById(id);
			s.setIdClient(id);
			s.setFirstName(Client.getFirstName());
			s.setLastName(Client.getLastName());
			s.setAdresse(Client.getAdresse());
			s.setDate(Client.getDate());
			s.setPhone(Client.getPhone());
			s.setEmail(Client.getEmail());
			s.setDatePayment(Client.getDatePayment());
			s.setHasPaid(Client.isHasPaid());
			s.setPack(Client.getPack());
			s.setWorkTime(Client.getWorkTime());
			
	 		// save updated student object
			cs.updateClient(s); 
			return "redirect:/Client";
			 
		}
		
		@GetMapping("/Client/{id}")
		public String deleteClient(@PathVariable Long id) {
			cs.deleteClientById(id);
			return "redirect:/Client";
	}

	 
	 
}
