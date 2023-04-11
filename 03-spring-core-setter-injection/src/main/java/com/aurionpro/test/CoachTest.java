package com.aurionpro.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.model.BasketballCoach;
import com.aurionpro.model.CricketCoach;
import com.aurionpro.model.ICoach;

public class CoachTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/aurionpro/model/applicationContext.xml");   //to copy the path right click on applicationContextEmail and select copy qualified name
		ICoach coach = (ICoach) context.getBean("cricketCoach", CricketCoach.class);
		ICoach coach2= (ICoach) context.getBean("cricketCoach", CricketCoach.class); //container will create only objects because it acts as a singleton and each class only get one bean if prototype keyword is not mentioned
		System.out.println(coach==coach2);//it will return true
		System.out.println(coach.hashCode());
		System.out.println(coach2.hashCode());
		System.out.println(coach.getTraining());
		// System.out.println(coach.getDietPlan());

		BasketballCoach coach1 = (BasketballCoach) context.getBean("basketBallCoach", BasketballCoach.class);
		context.close(); //this will call the destroy method prototype should not be mentioned in the bean 
		System.out.println(coach1.getTraining());
		// System.out.println(coach1.getDietPlan());

	}

}
///02-spring-core-xml-config/src/main/java/com/aurionpro/model/applicationContext.xml