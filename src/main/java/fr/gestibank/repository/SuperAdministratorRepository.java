package fr.gestibank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import fr.gestibank.entity.user.SuperAdministrator;

public interface SuperAdministratorRepository extends JpaRepository<SuperAdministrator, Long>{

	
	@Query ("FROM SuperAdministrator WHERE staff_number = :x")
	public SuperAdministrator getAdmin(@Param("x") Long id);
	
}
