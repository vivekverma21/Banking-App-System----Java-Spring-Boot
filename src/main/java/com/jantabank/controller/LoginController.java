package com.jantabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jantabank.entity.User;
import com.jantabank.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLoginForm()
	{
		return "login/login-form";
	}
	@PostMapping("/authenticateUser")
	public String authenticateUser(String userid,String password, Model model, HttpSession session)
	{
		User user=userService.getUser(userid);
		if(user==null)
		{
			model.addAttribute("userid", userid);
			model.addAttribute("msg", "Entered username does not exist!");
			return "login/login-form";
		}
		String dbPassword=user.getPassword();
		if(!password.equals(dbPassword))
		{
			model.addAttribute("userid", userid);
			model.addAttribute("msg", "Entered password is wrong!");
			return "login/login-form";
		}
		session.setAttribute("username", user.getFirstname()+" "+user.getLastname());
		long accountno=userService.getAccountNo(userid);
		session.setAttribute("accountno", accountno);
		return "redirect:/";
	}
	@GetMapping("/logout.do")
	public String logoutUser(HttpSession session, Model model)
	{
		model.addAttribute("username", session.getAttribute("username"));
		session.invalidate();
		return "login/logout-success";
	}
}
