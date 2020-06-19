package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.account.Debit;

public interface DebitRepository extends JpaRepository<Debit, Long>{

}
