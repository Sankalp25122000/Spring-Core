package com.aurionpro.model;

public class CricketCoach implements ICoach {

	private String name;
	private String email;
	private IDiet diet;

	public CricketCoach() {
		System.out.println("inside cricket constructor");
	}

	public IDiet getDiet() {
		return diet;

	}

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

	public void setDiet(IDiet diet) {
		this.diet = diet;
		System.out.println("inside setter of cricket");
	}

	@Override
	public String getTraining() {
		System.out.println("name is "+this.name);
		System.out.println("email is "+this.email);
		return "3 hr training";
	}

	@Override
	public String toString() {
		return "CricketCoach [name=" + name + ", email=" + email + ", diet=" + diet + "]";
	}

	
//	@Override
//	public String getDietPlan() {
//		return diet.getDietPlan();
//	}

}
