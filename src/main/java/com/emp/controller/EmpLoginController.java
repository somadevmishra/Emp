package com.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpLoginController {

	@RequestMapping(path="/succesful")
	public String successfulLogin(){
		return "successful";
	}
}
