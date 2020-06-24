package fr.gestibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gestibank.entity.user.Manager;
import fr.gestibank.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository repo;

	public List<Manager> listAll() {
		return repo.findAll();
	}
	
	public void save (Manager manager) {
		repo.save(manager);
	}
	
	public Manager get(Long id)
	{
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
