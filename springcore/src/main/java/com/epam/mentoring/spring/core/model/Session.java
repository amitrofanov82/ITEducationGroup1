package com.epam.mentoring.spring.core.model;

import java.time.LocalDateTime;
import java.util.List;

public class Session {

	private LocalDateTime time;
	private List<Integer> seats;

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Session [time=");
		builder.append(time);
		builder.append(", seats=");
		builder.append(seats);
		builder.append("]");
		return builder.toString();
	}

}
