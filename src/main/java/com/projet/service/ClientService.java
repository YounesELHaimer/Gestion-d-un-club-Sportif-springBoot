package com.projet.service;

import java.util.List;

import com.projet.entities.Client;



public interface ClientService {
	List<Client> getAllPers();
	
	Client savePers(Client emp);

	Client getClientById(Long id);

	void updateClient(Client s);

	void deleteClientById(Long id);
}
