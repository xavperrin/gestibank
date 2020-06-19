package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
