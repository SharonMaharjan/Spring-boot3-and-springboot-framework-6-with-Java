package com.in28minutes.springboot.myfirstwebapp.login;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.context.SecurityContextHolder;



@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	private AuthenticationService authenticationService = new AuthenticationService();
	
	
	public WelcomeController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoLoginPage(ModelMap model) 
	{
		model.put("name", "in28minutes");
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
