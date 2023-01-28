package com.projet.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.entities.Pack;

public interface packRepository extends JpaRepository<Pack, Long>{

}
