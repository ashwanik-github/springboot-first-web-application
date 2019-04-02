package com.springboot.webapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	//creating method to validate the username and the passwd
	public boolean validateUser(String username,String passwd){
		return(username.equals("dummy")&&passwd.equals("dummy"));
	}
	
}
