package com.projet.controller;

import java.sql.Date; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet.entities.Client;
import com.projet.entities.Plan;
import com.projet.entities.Pack;
import com.projet.entities.Personnel;
import com.projet.repo.ClientRepository;
import com.projet.repo.PlanRepository;
import com.projet.repo.packRepository;
import com.projet.repo.worktimeRepository;
import com.projet.repo.PersonnelRepository;
import com.projet.repo.adminRepository;
import com.projet.service.ClientSiteService;

@Controller
public class ClientContoller {
	
	@Autowired
	adminRepository arepo;
	
	@Autowired
	PersonnelRepository persodao;
	
	@Autowired
	private ClientRepository dao;
	
	@Autowired
	private PlanRepository plandao;
	
	@Autowired
	private packRepository packdao;

	@Autowired
	private worktimeRepository wR;

	@RequestMapping("/index")
	public String index(Model m)
	{
		m.addAttribute("packs",packdao.findAll());
		m.addAttribute("worktimes",wR.findAll());
		Long numClient = dao.count();
		Long numCoach = persodao.count();
		Client c = new Client();
		List<Plan> options = plandao.findPlan();
		m.addAttribute("options", options);
		m.addAttribute("Client",c);
		m.addAttribute("NumClient",numClient);
		m.addAttribute("NumCoach",numCoach);
		return "index";
	} 
	
	@Autowired
	private ClientSiteService ss;
	
	@PostMapping("/index/add")
	public String saveClient(@ModelAttribute("Client") Client Client
								/*,String firstName,
								String lastName,
								Date date,
								String adresse,
								Long phone,
								String email*/) {
		ss.saveClient(Client);
		return "redirect:/index";
	}
	
	/*@PostMapping("/index/pack")
	public void getPack(Model m,@ModelAttribute("option") String name) {
		Long id = plandao.findIdByName(name);
		List<Pack> options = packdao.findPackByIdPlan(id);
		m.addAttribute("packs", options);
	}*/
}
