package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // primary annotation helps to guide the code to select the object of particular
			// class by default
public class BasketBallCoach implements ICoach {

	IDiet diet;

	@Autowired
	public BasketBallCoach(@Qualifier(value = "sportsDiet") IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTrainingDetails() {
		return "Practice in Court in for 4 hours" + "\n" + diet.getDietPlan();
	}

	@Override
	public String getDietPlann() {
		// TODO Auto-generated method stub
		return diet.getDietPlan();
	}

}
