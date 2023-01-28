package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.entities.Job;
import com.projet.repo.jobRepository;
import com.projet.service.JobService;



@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private jobRepository er; 
	@Override
	public List<Job> getAllPers() {
		
		return er.findAll();
	}
	@Override
	public Job savePers(Job emp) {
		
		return er.save(emp);
	}
	@Override
	public Job getJobById(Long id) {
		
		return er.findById(id).get();
	}
	@Override
	public void updateJob(Job s) {
		// TODO Auto-generated method stub
		er.save(s);
	}
	@Override
	public void deleteJobById(Long id) {
		er.deleteById(id);
		
	}
	
	
	

}
