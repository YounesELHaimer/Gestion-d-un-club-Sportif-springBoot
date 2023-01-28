package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.entities.WorkTime;
import com.projet.repo.worktimeRepository;
import com.projet.service.WorktimeService;



@Service
public class WorktimeServiceImpl implements WorktimeService {
	
	@Autowired
	private worktimeRepository er; 
	@Override
	public List<WorkTime> getAllPers() {
		
		return er.findAll();
	}
	@Override
	public WorkTime savePers(WorkTime emp) {
		
		return er.save(emp);
	}
	@Override
	public WorkTime getWorktimeById(Long id) {
		
		return er.findById(id).get();
	}
	@Override
	public void updateWorktime(WorkTime s) {
		// TODO Auto-generated method stub
		er.save(s);
	}
	@Override
	public void deleteWorktimeById(Long id) {
		er.deleteById(id);
		
	}
	
	
	

}
