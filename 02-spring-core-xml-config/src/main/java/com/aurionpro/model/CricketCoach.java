package com.aurionpro.model;

public class CricketCoach implements ICoach {

	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private IDiet diet;

	public CricketCoach() {
		System.out.println("Inside cricket coach contructor..");
	}

	public IDiet getDiet() {
		return diet;
	}

	public void setDiet(IDiet diet) {
		this.diet = diet;
		System.out.println("Inside cricket coach setter");

	}

	@Override
	public String getTraining() {
		return "practice in nets for 4 hours";
	}

//	@Override
//	public String getDietPlan() {
//		// TODO Auto-generated method stub
//		return diet.getDietPlan();
//	}

}
