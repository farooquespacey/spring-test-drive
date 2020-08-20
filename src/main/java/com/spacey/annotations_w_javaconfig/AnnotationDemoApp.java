package com.spacey.annotations_w_javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		CoachAnnotations aCoach = context.getBean("thatSillyCoach", CoachAnnotations.class);

		// get the bean from spring container
		CoachAnnotations anotherCoach = context.getBean("thatSillyCoach", CoachAnnotations.class);

		// call a method on the bean
		System.out.println(aCoach.getDailyWorkout());

		// call a dependency of the bean
		System.out.println(aCoach.getDailyFortune());

		// Try this after removing @Scope.. from the TennisCoach class
		System.out.println("theCoach == anotherCoach ? " + (aCoach == anotherCoach));

		System.out.println("=========================================");
		
		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// call our new swim coach methods ... has the props value injected
		System.out.println("email : " + theCoach.getEmail());
		System.out.println("team : " + theCoach.getTeam());

		System.out.println("theCoach == anotherCoach ? " + (aCoach == anotherCoach));

		// close the context
		context.close();
	}

}