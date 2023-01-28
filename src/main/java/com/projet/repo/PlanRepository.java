package com.projet.repo;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.entities.Admin;
import com.projet.entities.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long>{
	
	@Query("select p from Plan p")
	public List<Plan> findPlan();

	
}
