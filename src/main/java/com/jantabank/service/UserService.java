package com.jantabank.service;

import com.jantabank.entity.User;

public interface UserService 
{
	long createUser(User user);
	User getUser(String userid);
	long getAccountNo(String userid);
}

