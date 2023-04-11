package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

@RestController // Here we are using rest
@RequestMapping("/app")
public class TestController {

	private ICoach coach;

	@Autowired
	public TestController(@Qualifier(value = "basketBallCoach") ICoach coach) { // AutowWired helps to find objects with
																				// the help of Component annotation
		super(); // Qualifier helps to find bean of mentioned class and value is mentioned in
					// lowerCase because it by default create class variables in lower case
		this.coach = coach;
	}

	@GetMapping("/hello") // It is a type of request from one of 4 get, post, push and delete
	public String greetMessage() {
		return coach.getTrainingDetails();
	}

	@GetMapping("/test") // It is a type of request from one of 4 get, post, push and delete
	public String newMessage() {
		return "testing message";
	}
}
