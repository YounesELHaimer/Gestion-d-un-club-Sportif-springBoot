package com.projet.service;

import java.util.List; 

import com.projet.entities.Client;
import com.projet.entities.Plan;



public interface ClientSiteService {
	List<Plan> findAllPlans();
	
	List<Client> getAllClients();
	
	Client saveClient(Client emp);

	Client getClientById(Long id);

	void updateClient(Client s);

	void deleteClientById(Long id);
}
