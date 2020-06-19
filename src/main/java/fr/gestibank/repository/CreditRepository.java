package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.account.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long>
{

}
