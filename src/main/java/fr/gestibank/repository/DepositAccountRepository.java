package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.account.DepositAccount;

public interface DepositAccountRepository extends JpaRepository<DepositAccount, Long>{

}
