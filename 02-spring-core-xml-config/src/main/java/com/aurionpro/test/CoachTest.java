package com.aurionpro.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.model.CricketCoach;
import com.aurionpro.model.ICoach;

public class CoachTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/aurionpro/model/applicationContext.xml"); // path copies by right clicking on
																// applicationContext.xml and selecting copy qualilfied
																// name
		CricketCoach coach = (CricketCoach) context.getBean("cricketCoach", CricketCoach.class);
		ICoach coach1 = (ICoach) context.getBean("basketBallCoach", ICoach.class);
		//System.out.println(coach.getTraining());
		System.out.println(coach.getEmail());
		System.out.println(coach1.getTraining());
		context.close();
//		System.out.pri;tln(coach.getDietPlan());
//		System.out.println(coach1.getDietPlan());
	}

}
