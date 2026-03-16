
package com.jantabank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController 
{
	@GetMapping //url->http://localhost:8080/JantaBank/
	public String getHomeView(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			return "login/login-form";
		}
		return "home/home-page";
	}
}
