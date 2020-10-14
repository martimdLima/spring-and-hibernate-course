package com.martimlima.springbootdemo.restcontroller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoRestController {
	
	// inject properties for: coach.name and team.name
	
	@Value("${coach.name}")
	String coach;
	
	@Value("${team.name}")
	String team;
	
	@GetMapping("/time")
	public String getServerTime() {
		
		String currentTime = LocalDateTime.now().toString();
		
		System.out.println("Server's current time is: " + currentTime);
		
		return currentTime;
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "run 5km today";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamDetails() {
		return "The coach of the " + team + "'s is " + coach;  
	}
}
