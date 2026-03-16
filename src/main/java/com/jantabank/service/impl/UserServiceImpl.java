package com.jantabank.service.impl;

import org.springframework.stereotype.Service;

import com.jantabank.entity.Account;
import com.jantabank.entity.User;
import com.jantabank.repository.AccountRepository;
import com.jantabank.repository.UserRepository;
import com.jantabank.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	private UserRepository userRepository;
	private AccountRepository accountRepository;
	public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository)
	{
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
	}

	public long createUser(User user) 
	{
		userRepository.save(user);
		Account account=new Account();
		account.setUserid(user.getUserid());
		Account accountSaved=accountRepository.save(account);
		return accountSaved.getAccountno();
	}

	public User getUser(String userid) 
	{
		User user=userRepository.findById(userid).orElse(null);
		return user;
	}

	public long getAccountNo(String userid) 
	{
		long accountno=accountRepository.getAccountNumber(userid);
		return accountno;
	}
}

