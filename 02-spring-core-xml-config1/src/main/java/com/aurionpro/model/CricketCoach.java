package com.aurionpro.model;

public class CricketCoach implements ICoach {
	
	IDiet diet;
	

	public CricketCoach(IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTraining() {
		return "practice in nets for 4 hours";
	}

	@Override
	public String getDietPlan() {
		// TODO Auto-generated method stub
		return diet.getDietPlan();
	}

}
