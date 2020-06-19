package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.account.SavingAccount;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {

}
