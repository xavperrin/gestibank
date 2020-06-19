package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.society.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
