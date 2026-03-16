package com.jantabank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jantabank.entity.Account;
import com.jantabank.repository.AccountRepository;
import com.jantabank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService 
{
	@Autowired private AccountRepository accountRepository;
	
	public int getAmount(long accountno) 
	{
		return accountRepository.getAmount(accountno);
	}

	public void depositMoney(int amount, long accountno) 
	{
		Account account=accountRepository.findById(accountno).orElse(null);
		account.setAmount(account.getAmount()+amount);
		accountRepository.save(account);
	}
}

