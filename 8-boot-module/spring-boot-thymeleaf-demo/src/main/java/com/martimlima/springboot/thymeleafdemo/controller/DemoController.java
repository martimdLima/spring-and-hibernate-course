package com.martimlima.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	// create mapping for "/home"
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("currentDate", new java.util.Date());
		
		return "home";
	}

}
