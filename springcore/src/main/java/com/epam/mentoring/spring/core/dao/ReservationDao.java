package com.epam.mentoring.spring.core.dao;

import com.epam.mentoring.spring.core.model.Reservation;

public interface ReservationDao {

	public void delete(String number);

	public Reservation find(String number);

}
