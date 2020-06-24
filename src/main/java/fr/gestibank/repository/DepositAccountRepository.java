package fr.gestibank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.gestibank.entity.account.DepositAccount;

public interface DepositAccountRepository extends JpaRepository<DepositAccount, Long>{

	
	/*@Query ("FROM deposit_account WHERE fk_customer_id = :x")
	  List<DepositAccount> findByCustomerId(@Param("x") Long id);*/
}
