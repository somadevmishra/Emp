package com.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpLoginController {

	@RequestMapping(path="/succesful", method=RequestMethod.POST)
	public String successfulLogin(){
		return "successful";
	}
	@RequestMapping(path="/login")
	public String login(){
		return "login";
	}
}
