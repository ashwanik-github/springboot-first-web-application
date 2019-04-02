package com.springboot.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.webapplication.service.LoginService;

@Controller   //this will map the Controller to be picked up by the DispacherServlet
@SessionAttributes("name")
public class LoginController {
	//creating a service class for the validation here
	@Autowired
	LoginService service;
	
	// Change 1: Implementing the spring security by enabling the redirection 
	@RequestMapping(value ="/", method= RequestMethod.GET)   //this will map the login as the start of spring-boot
	public String loginPage(ModelMap model){
		model.put("name", "dummy");
		//model.put("name", name);
		//System.out.println(name);
		//return "login"; //as soon as a user types anything he will be redirected to welcome page
		return "welcome";
	}
	@RequestMapping(value ="/login", method= RequestMethod.POST)   //this will map the login as the start of spring-boot
	public String wlecomeMessage(ModelMap model,@RequestParam String name,@RequestParam String passwd){
		boolean isValidUser = service.validateUser(name, passwd);
		if(!isValidUser){
			model.put("errorMessage", "Invalid Credentials");
			return ("login");
		}
		model.put("name", name);
		model.put("passwd", passwd);
		//System.out.println(name);
		return "welcome";
	}
}
