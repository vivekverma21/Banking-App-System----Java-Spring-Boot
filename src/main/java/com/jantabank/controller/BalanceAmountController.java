package com.jantabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.jantabank.repository.AccountRepository;
import com.jantabank.service.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BalanceAmountController 
{

    @Autowired
	private AccountService accountService;

    @GetMapping("/viewBalance")
	public ModelAndView getBalanceView(@SessionAttribute long accountno)
	{
		int amount=accountService.getAmount(accountno);
		ModelAndView modelAndView=new ModelAndView("services/balance/show-balance");
		modelAndView.addObject("amount", amount);
		return modelAndView;
	}
}

