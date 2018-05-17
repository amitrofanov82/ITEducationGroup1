package com.epam.mentoring.spring.core.service;

import com.epam.mentoring.spring.core.dao.ReservationDao;
import com.epam.mentoring.spring.core.model.Reservation;

public interface ReservationService {

	public void delete(String number);

	public Reservation find(String number);

	public void setReservationDao(ReservationDao dao);
}
