package com.projet.service;

import java.util.List;

import com.projet.entities.Plan;



public interface PlanService {
	List<Plan> getAllPers();
	
	Plan savePers(Plan emp);

	Plan getPlanById(Long id);

	void updatePlan(Plan s);

	void deletePlanById(Long id);
}
