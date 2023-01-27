package com.projet.repo;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.entities.Admin;




public interface adminRepository extends JpaRepository<Admin, Long> {
	
	
	
	@Query("from Admin where username=?1 and password=?2")
	public Admin findByUsernamePassword(String name,String password);

}