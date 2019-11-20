package com.app.service;

import java.util.List;

import com.app.model.BankAccount;

public interface IBankAccountService {
	
	public void saveBankAccount(BankAccount b);
	public BankAccount getOneAccount(Integer id);
	public List<BankAccount> getAllAccounts();
	public void deleteAccount(Integer id);
	
	public boolean isExist(Integer id);

}
