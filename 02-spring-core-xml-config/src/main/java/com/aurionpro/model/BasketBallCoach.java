package com.aurionpro.model;

public class BasketBallCoach implements ICoach {

	private IDiet diet;

	public BasketBallCoach() {
		System.out.println("Inside basketBall coach constructor..");
	}

	public IDiet getDiet() {
		return diet;
	}

	public void setDiet(IDiet diet) {
		this.diet = diet;
		System.out.println("Inside basketBall coach setter");

	}

	@Override
	public String getTraining() {
		return "Practice for 8 hours in court";
	}
//
//	@Override
//	public String getDietPlan() {
//		return diet.getDietPlan();
//	}

}
