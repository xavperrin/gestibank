package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.user.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
