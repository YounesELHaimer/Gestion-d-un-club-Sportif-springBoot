package com.projet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.entities.Pack;
import com.projet.entities.Plan;

public interface packRepository extends JpaRepository<Pack, Long> {

	@Query("Select p.price from Pack p inner join Plan pl where pl.idPlan = 1")
	public List<Integer> findPriceStandard();

	
	@Query("Select p.price from Pack p inner join Plan pl where pl.idPlan = 2")
	public List<Long> findPricePremium();
}
