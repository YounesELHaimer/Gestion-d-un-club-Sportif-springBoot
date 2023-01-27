package com.projet.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projet.entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long>{

}
