package com.jantabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jantabank.entity.User;

public interface UserRepository extends JpaRepository<User, String> 
{
}

