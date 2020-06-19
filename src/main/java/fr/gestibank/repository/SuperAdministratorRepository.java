package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.user.SuperAdministrator;

public interface SuperAdministratorRepository extends JpaRepository<SuperAdministrator, Long>{

}
