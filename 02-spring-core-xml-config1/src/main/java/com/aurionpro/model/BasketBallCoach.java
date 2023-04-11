package com.aurionpro.model;

public class BasketBallCoach implements ICoach {
	
	IDiet diet;

	public BasketBallCoach(IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTraining() {
		return "Practice for 8 hours in court";
	}

	@Override
	public String getDietPlan() {
		return diet.getDietPlan();
	}

}
