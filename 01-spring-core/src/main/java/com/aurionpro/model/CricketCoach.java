package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {

	IDiet diet;

	public CricketCoach(@Qualifier(value = "weightLossDiet") IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTrainingDetails() {
		return "Practice in the nets for 3 hours" + "\n" + diet.getDietPlan();
	}

	@Override
	public String getDietPlann() {
		// TODO Auto-generated method stub
		return diet.getDietPlan();
	}

}
