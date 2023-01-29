package com.projet.service;

import java.util.List;

import com.projet.entities.Admin;



public interface AdminService {
	List<Admin> getAllPers();
	
	Admin savePers(Admin emp);

	Admin getAdminById(Long id);

	void updateAdmin(Admin s);

	void deleteAdminById(Long id);
}
