package com.jantabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jantabank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> 
{
	@Query("select accountno from Account where userid=:arg")
	long getAccountNumber(@Param("arg") String userid);

	@Query("select amount from Account where accountno=:arg")
	int getAmount(@Param("arg") long accountno);
}

