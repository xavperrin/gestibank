package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.account.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

}
