package com.epam.mentoring.spring.core.configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.epam.mentoring.spring.core.model.Reservation;
import com.epam.mentoring.spring.core.model.Session;
import com.epam.mentoring.spring.core.model.User;

@Configuration
@Profile("test")
public class TestBeansConfiguration {

	@Autowired
	private User user;

	@Bean
	public Reservation reservation() {
		Reservation reservation = new Reservation();
		reservation.setCost(10.0);
		reservation.setCustomer(user);
		reservation.setFilmName("Test film");
		reservation.setNumber("12345");
		return reservation;
	}

	@Bean
	public Session session() {
		Session session = new Session();
		session.setTime(LocalDateTime.of(2017, 4, 7, 15, 0));
		session.setSeats(Arrays.asList(1, 2, 3, 4, 5));
		return session;
	}

	@Bean
	public User user() {
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		return user;
	}
}
