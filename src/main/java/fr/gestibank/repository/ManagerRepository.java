package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.user.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
