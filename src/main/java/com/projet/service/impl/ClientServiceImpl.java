package com.projet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projet.entities.Client;
import com.projet.repo.ClientRepository;
import com.projet.service.ClientService;



@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository er; 
	@Override
	public List<Client> getAllPers() {
		
		return er.findAll();
	}
	@Override
	public Client savePers(Client emp) {
		
		return er.save(emp);
	}
	@Override
	public Client getClientById(Long id) {
		
		return er.findById(id).get();
	}
	@Override
	public void updateClient(Client s) {
		// TODO Auto-generated method stub
		er.save(s);
	}
	@Override
	public void deleteClientById(Long id) {
		er.deleteById(id);
		
	}
	
	
	

}
