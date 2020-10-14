package com.martimlima.springcourse.securitymodule.customloginForm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "plain-login";
	}
}
