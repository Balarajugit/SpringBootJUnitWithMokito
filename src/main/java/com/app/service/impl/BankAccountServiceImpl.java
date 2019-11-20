package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.BankAccount;
import com.app.repository.BankAccountRepository;
import com.app.service.IBankAccountService;
@Service
public class BankAccountServiceImpl implements IBankAccountService {
	@Autowired
	private BankAccountRepository repo;
	
	@Transactional
	public void saveBankAccount(BankAccount b) {
		repo.save(b);
		
	}
	@Transactional(readOnly = true)
	public BankAccount getOneAccount(Integer id) {
		Optional<BankAccount> obj = repo.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
	return null;
	}
	
	@Transactional(readOnly = true)
	public List<BankAccount> getAllAccounts() {
		
		return repo.findAll();
	}
	
	@Transactional
	public void deleteAccount(Integer id) {
		repo.deleteById(id);
		
	}
	
	@Transactional
	public boolean isExist(Integer id) {
		return repo.existsById(id);
		
	}
}
