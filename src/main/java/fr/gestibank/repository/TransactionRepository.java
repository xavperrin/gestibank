package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.account.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
