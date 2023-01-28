package com.projet.service;

import java.util.List;

import com.projet.entities.Job;



public interface JobService {
	List<Job> getAllPers();
	
	Job savePers(Job emp);

	Job getJobById(Long id);

	void updateJob(Job s);

	void deleteJobById(Long id);
}
