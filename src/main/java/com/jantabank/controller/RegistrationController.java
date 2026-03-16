package com.jantabank.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jantabank.entity.User;
import com.jantabank.service.UserService;

@Controller
public class RegistrationController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String getRegistrationForm(Model model)
	{
		model.addAttribute("maxDob", LocalDate.now().minusYears(18));
        model.addAttribute("minDob", LocalDate.now().minusYears(100));
		return "registration/registration-form";
	}
	
	@PostMapping("/registration.do")
	public String registerUser(User user, Model model)
	{
		long accountno=userService.createUser(user);
		model.addAttribute("accountno",accountno);
		return "registration/registration-success";
	}
}

