package com.spacey.annotations_w_javaconfig;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements CoachAnnotations {

	private FortuneService fortuneService;
	@Value("${foo.email}") // new
	private String email;

	@Value("${foo.team}") // new
	private String team;

	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getEmail() { // new
		return email;
	}

	public String getTeam() { // new
		return team;
	}

}