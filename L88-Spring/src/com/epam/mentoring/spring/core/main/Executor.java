package com.epam.mentoring.spring.core.main;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.mentoring.spring.core.configuration.BaseBeansConfiguration;
import com.epam.mentoring.spring.core.configuration.ProdBeansConfiguration;
import com.epam.mentoring.spring.core.configuration.TestBeansConfiguration;
import com.epam.mentoring.spring.core.service.ReservationService;
import com.epam.mentoring.spring.core.service.SessionService;

public class Executor {

	private static final Logger logger = Logger.getLogger(Executor.class);

	// To specify active profile use VM argument:
	// -Dspring.profiles.active="profile_name"
	public static void main(String[] args) {
		ConfigurableApplicationContext context 
			= new AnnotationConfigApplicationContext(
				BaseBeansConfiguration.class,
				ProdBeansConfiguration.class, 
				TestBeansConfiguration.class);

		SessionService sessionService = context.getBean(SessionService.class);
		ReservationService reservationService = context.getBean(ReservationService.class);
		System.out.println("Find session result: " + sessionService.findAll(LocalDateTime.of(2017, 4, 7, 15, 0)));
		System.out.println("Reservation after find method call: " + reservationService.find("12345"));
		reservationService.delete("12345");
		System.out.println("Reservation after delete and find method call: " + reservationService.find("12345"));
		context.close();
	}
}






https://www.googleapis.com/customsearch/v1









