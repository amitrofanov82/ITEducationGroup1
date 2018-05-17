package com.epam.mentoring.spring.core.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.spring.core.dao.ReservationDao;
import com.epam.mentoring.spring.core.model.Reservation;

public class ReservationDaoImpl implements ReservationDao {

	private static final Logger logger = Logger.getLogger(ReservationDaoImpl.class);

	@Autowired
	private List<Reservation> reservations;

	public void delete(String number) {
		reservations.removeIf(reservation -> reservation.getNumber().equals(number));
	}

	public Reservation find(String number) {
		return reservations.stream().filter(reservation -> reservation.getNumber().equals(number)).findAny()
				.orElse(null);
	}

	private void destroy() {
		logger.info("**** Reserations before destroy ****");
		reservations.forEach(reservation -> logger.info("Reservation exists: " + reservation));
	}
}
