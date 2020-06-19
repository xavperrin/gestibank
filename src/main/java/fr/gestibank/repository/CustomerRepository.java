package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.user.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
