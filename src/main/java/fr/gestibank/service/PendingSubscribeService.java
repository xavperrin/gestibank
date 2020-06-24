package fr.gestibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gestibank.entity.user.PendingSubscribe;
import fr.gestibank.repository.PendingSubscribeRepository;



@Service
@Transactional
public class PendingSubscribeService {

	@Autowired
    private PendingSubscribeRepository repo;
     
    public List<PendingSubscribe> listAll() {
        return repo.findAll();
    }
     
    public void save(PendingSubscribe pending) {
        repo.save(pending);
    }
     
    public PendingSubscribe get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
