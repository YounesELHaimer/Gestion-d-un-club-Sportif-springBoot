package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.entities.Plan;
import com.projet.repo.PlanRepository;
import com.projet.service.PlanService;



@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanRepository er; 
	@Override
	public List<Plan> getAllPers() {
		
		return er.findAll();
	}
	@Override
	public Plan savePers(Plan emp) {
		
		return er.save(emp);
	}
	@Override
	public Plan getPlanById(Long id) {
		
		return er.findById(id).get();
	}
	@Override
	public void updatePlan(Plan s) {
		// TODO Auto-generated method stub
		er.save(s);
	}
	@Override
	public void deletePlanById(Long id) {
		er.deleteById(id);
		
	}
	
	
	

}
