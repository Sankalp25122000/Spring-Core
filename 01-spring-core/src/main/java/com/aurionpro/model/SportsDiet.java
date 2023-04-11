package com.aurionpro.model;

import org.springframework.stereotype.Component;

@Component
public class SportsDiet implements IDiet {

	@Override
	public String getDietPlan() {
		return "Eat protein to be ready for sports";
	}

}
