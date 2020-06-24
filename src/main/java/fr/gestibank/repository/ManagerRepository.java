package fr.gestibank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.gestibank.entity.user.Customer;
import fr.gestibank.entity.user.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{

	
	@Query ("FROM Customer WHERE fk_manager_id = :x")
	public List<Customer> assignedCustomers(@Param("x") Long id);
	
}
