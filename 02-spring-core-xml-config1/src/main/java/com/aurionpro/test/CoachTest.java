package com.aurionpro.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.model.ICoach;

public class CoachTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/aurionpro/model/applicationContext.xml"); // path copies by right clicking on
																// applicationContext.xml and selecting copy qualilfied
																// name
		ICoach coach = (ICoach) context.getBean("cricketCoach", ICoach.class);
		ICoach coach1 = (ICoach) context.getBean("basketBallCoach", ICoach.class);
		System.out.println(coach.getTraining());
		System.out.println(coach1.getTraining());
		System.out.println(coach.getDietPlan());
		System.out.println(coach1.getDietPlan());
	}

}
