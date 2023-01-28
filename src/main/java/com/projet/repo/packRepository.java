package com.projet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entities.Pack;

public interface packRepository extends JpaRepository<Pack, Long> {

}
