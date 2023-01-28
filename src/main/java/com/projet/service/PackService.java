package com.projet.service;

import java.util.List;

import com.projet.entities.Pack;



public interface PackService {
	List<Pack> getAllPers();
	
	Pack savePers(Pack emp);

	Pack getPackById(Long id);

	void updatePack(Pack s);

	void deletePackById(Long id);
}
