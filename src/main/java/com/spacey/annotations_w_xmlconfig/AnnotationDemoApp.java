package com.spacey.annotations_w_xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextAnnotations.xml");

		// get the bean from spring container
		CoachAnnotations theCoach = context.getBean("thatSillyCoach", CoachAnnotations.class);

		// get the bean from spring container
		CoachAnnotations anotherCoach = context.getBean("thatSillyCoach", CoachAnnotations.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a dependency of the bean
		System.out.println(theCoach.getDailyFortune());

		// Try this after removing @Scope.. from the TennisCoach class
		System.out.println("theCoach == anotherCoach ? " + (theCoach == anotherCoach));

		// close the context
		context.close();
	}

}