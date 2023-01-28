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
import com.projet.entities.Pack;
import com.projet.entities.Personnel;
import com.projet.entities.Plan;
import com.projet.entities.WorkTime;
import com.projet.repo.ClientRepository;
import com.projet.repo.PersonnelRepository;
import com.projet.repo.PlanRepository;
import com.projet.repo.adminRepository;
import com.projet.repo.jobRepository;
import com.projet.repo.packRepository;
import com.projet.repo.worktimeRepository;
import com.projet.service.ClientService;
import com.projet.service.JobService;
import com.projet.service.PackService;
import com.projet.service.PersonnelService;
import com.projet.service.PlanService;
import com.projet.service.WorktimeService;


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

		//####################################### partie Job #######################################
		
		@Autowired
		private JobService js;

	

		@GetMapping("/Job")
		public String listJob(Model m ) {
		    m.addAttribute("badre",js.getAllPers());
		    return "Job";
		}

		@GetMapping("/Job/new")

		public String createJobForm(Model m) {
		
		    Job e = new Job();
		    m.addAttribute("Job",e);
		    return "create_Job";
		    
		    
		} 

		 

		@PostMapping("/Job/add")
		public String saveJob(@ModelAttribute("Job") Job Job) {
		    js.savePers(Job);
		    return "redirect:/Job";
		}
		@GetMapping("/Job/edit/{id}")

		public String updateJobForm(@PathVariable Long id,Model m) {
		    Job e =  js.getJobById(id);
		    m.addAttribute("Job",e);
		    return "edit_Job";
		    
		     
		} 
		@PostMapping("/Job/{id}")
		public String updateJob(@PathVariable Long id,@ModelAttribute("Job") Job Job) {
		    // get student from db by id
		    
		    Job s  = js.getJobById(id);
		    s.setIdJob(id);
		    s.setTitle(Job.getTitle());
		   
		    
		     // save updated student object
		    js.updateJob(s); 
		    return "redirect:/Job";
		     
		}

		@GetMapping("/Job/{id}")
		public String deleteJob(@PathVariable Long id) {
		    js.deleteJobById(id);
		    return "redirect:/Job";
		}


		//####################################### partie Pack #######################################
			
		@Autowired
		private PackService ps;

		@Autowired
		private PlanRepository PR;

		


		@GetMapping("/Pack")
		public String listPack(Model m ) {
		    m.addAttribute("badre",ps.getAllPers());
		    return "Pack";
		}

		@GetMapping("/Pack/new")

		public String createPackForm(Model m) {
		    m.addAttribute("plans",PR.findAll());
		   
		    Pack e = new Pack();
		    m.addAttribute("Pack",e);
		    return "create_Pack";
		    
		    
		} 

		 

		@PostMapping("/Pack/add")
		public String savePack(@ModelAttribute("Pack") Pack Pack) {
		    ps.savePers(Pack);
		    return "redirect:/Pack";
		}
		@GetMapping("/Pack/edit/{id}")

		public String updatePackForm(@PathVariable Long id,Model m) {
			 m.addAttribute("plans",PR.findAll());
		    Pack e =  ps.getPackById(id);
		    m.addAttribute("Pack",e);
		    return "edit_Pack";
		    
		     
		} 
		@PostMapping("/Pack/{id}")
		public String updatePack(@PathVariable Long id,@ModelAttribute("Pack") Pack Pack) {
		    // get student from db by id
		    
		    Pack s  = ps.getPackById(id);
		    s.setIdPack(id);
		    s.setName(Pack.getName());
		    s.setDuree(Pack.getDuree());
		    s.setPrice(Pack.getPrice());
		    s.setPlan(Pack.getPlan());
		   
		    
		     // save updated student object
		    ps.updatePack(s); 
		    return "redirect:/Pack";
		     
		}

		@GetMapping("/Pack/{id}")
		public String deletePack(@PathVariable Long id) {
		    ps.deletePackById(id);
		    return "redirect:/Pack";
		}


		//####################################### partie Plan #######################################
		
				@Autowired
				private PlanService Ps;

			

				@GetMapping("/Plan")
				public String listPlan(Model m ) {
				    m.addAttribute("badre",Ps.getAllPers());
				    return "Plan";
				}

				@GetMapping("/Plan/new")

				public String createPlanForm(Model m) {
				
				    Plan e = new Plan();
				    m.addAttribute("Plan",e);
				    return "create_Plan";
				    
				    
				} 

				 

				@PostMapping("/Plan/add")
				public String savePlan(@ModelAttribute("Plan") Plan Plan) {
				    Ps.savePers(Plan);
				    return "redirect:/Plan";
				}
				@GetMapping("/Plan/edit/{id}")

				public String updatePlanForm(@PathVariable Long id,Model m) {
				    Plan e =  Ps.getPlanById(id);
				    m.addAttribute("Plan",e);
				    return "edit_Plan";
				    
				     
				} 
				@PostMapping("/Plan/{id}")
				public String updatePlan(@PathVariable Long id,@ModelAttribute("Plan") Plan Plan) {
				    // get student from db by id
				    
				    Plan s  = Ps.getPlanById(id);
				    s.setIdPlan(id);
				    s.setName(Plan.getName());
				   
				    
				     // save updated student object
				    Ps.updatePlan(s); 
				    return "redirect:/Plan";
				     
				}

				@GetMapping("/Plan/{id}")
				public String deletePlan(@PathVariable Long id) {
				    Ps.deletePlanById(id);
				    return "redirect:/Plan";
				}

		//####################################### partie Worktime #######################################
				
				@Autowired
				private WorktimeService ws;

			

				@GetMapping("/Worktime")
				public String listWorktime(Model m ) {
				    m.addAttribute("badre",ws.getAllPers());
				    return "Worktime";
				}

				@GetMapping("/Worktime/new")

				public String createWorktimeForm(Model m) {
				
				    WorkTime e = new WorkTime();
				    m.addAttribute("Worktime",e);
				    return "create_Worktime";
				    
				    
				} 

				 

				@PostMapping("/Worktime/add")
				public String saveWorktime(@ModelAttribute("Worktime") WorkTime Worktime) {
				    ws.savePers(Worktime);
				    return "redirect:/Worktime";
				}
				@GetMapping("/Worktime/edit/{id}")

				public String updateWorktimeForm(@PathVariable Long id,Model m) {
				    WorkTime e =  ws.getWorktimeById(id);
				    m.addAttribute("Worktime",e);
				    return "edit_Worktime";
				    
				     
				} 
				@PostMapping("/Worktime/{id}")
				public String updateWorktime(@PathVariable Long id,@ModelAttribute("Worktime") WorkTime Worktime) {
				    // get student from db by id
				    
				    WorkTime s  = ws.getWorktimeById(id);
				    s.setIdWorkTime(id);
				    s.setDayOne(Worktime.getDayOne());
				    s.setDayTwo(Worktime.getDayTwo());
				    s.setDayThree(Worktime.getDayThree());
				   
				    
				     // save updated student object
				    ws.updateWorktime(s); 
				    return "redirect:/Worktime";
				     
				}

				@GetMapping("/Worktime/{id}")
				public String deleteWorktime(@PathVariable Long id) {
				    ws.deleteWorktimeById(id);
				    return "redirect:/Worktime";
				}

}
