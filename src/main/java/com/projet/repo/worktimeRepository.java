package com.projet.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projet.entities.WorkTime;

public interface worktimeRepository extends JpaRepository<WorkTime, Long> {
	
	

}
