package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

}
