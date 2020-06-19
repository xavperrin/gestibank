package fr.gestibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gestibank.entity.user.PendingSubscribe;

public interface PendingSubscribeRepository extends JpaRepository<PendingSubscribe, Long>{

}
