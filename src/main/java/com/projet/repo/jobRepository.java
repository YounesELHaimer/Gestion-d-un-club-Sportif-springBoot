package com.projet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entities.Job;

public interface jobRepository extends JpaRepository<Job, Long> {
	public Job findByTitle(String email);
}
