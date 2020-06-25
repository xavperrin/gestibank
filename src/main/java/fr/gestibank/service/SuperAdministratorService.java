package fr.gestibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gestibank.entity.user.Manager;
import fr.gestibank.entity.user.SuperAdministrator;
import fr.gestibank.repository.SuperAdministratorRepository;



@Service
public class SuperAdministratorService {

	@Autowired
	private SuperAdministratorRepository repo;
	
	public SuperAdministrator get(Long id)
	{
		return repo.findById(id).get();
	}
	
	
	
	
	public SuperAdministrator getAdmin(Long id)
	{
		return repo.getAdmin(id);
	}
	
	
}
