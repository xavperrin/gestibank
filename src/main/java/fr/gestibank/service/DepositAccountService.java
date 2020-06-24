package fr.gestibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gestibank.entity.account.DepositAccount;
import fr.gestibank.repository.DepositAccountRepository;

@Service
@Transactional
public class DepositAccountService {
	@Autowired
	private DepositAccountRepository repo;

	public List<DepositAccount> listAll() {
		return repo.findAll();
	}
		
	
}
