package com.jantabank.service;

public interface AccountService 
{
	int getAmount(long accountno);
	void depositMoney(int amount, long accountno);
}

