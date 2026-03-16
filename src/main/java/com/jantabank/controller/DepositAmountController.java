package com.jantabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.jantabank.repository.AccountRepository;
import com.jantabank.service.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DepositAmountController 
{

    @Autowired
	private AccountService accountService;

    @GetMapping("/depositMoney")
	public String getDepositMoneyView()
	{
		return "services/deposit/deposit-money-form";
	}
    @GetMapping("/deposit.do")
   	public String depositAmount(int amount,@SessionAttribute long accountno,Model model)
   	{
    	accountService.depositMoney(amount,accountno);
    	model.addAttribute("amount", amount);
   		return "services/deposit/deposit-success";
   	}
}

