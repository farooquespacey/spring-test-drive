package com.spacey.annotations_w_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//ComponentScan can be Commented and Tennis bean also can be manually defined in this file
@ComponentScan("com.spacey.annotations_w_javaconfig")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// add support to resolve ${...} properties (new)
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public FortuneService sadFortuneBean() {
		System.out.println("FS Called");
		return new SadFortuneService();
	}

	@Bean
	public CoachAnnotations swimCoach() {
		System.out.println("CA Called");
		return new SwimCoach(sadFortuneBean());
	}
}