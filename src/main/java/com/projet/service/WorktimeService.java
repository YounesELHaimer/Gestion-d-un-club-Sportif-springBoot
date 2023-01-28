package com.projet.service;

import java.util.List;

import com.projet.entities.WorkTime;



public interface WorktimeService {
	List<WorkTime> getAllPers();
	
	WorkTime savePers(WorkTime emp);

	WorkTime getWorktimeById(Long id);

	void updateWorktime(WorkTime s);

	void deleteWorktimeById(Long id);
}
