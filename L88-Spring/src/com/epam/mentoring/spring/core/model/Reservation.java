package com.epam.mentoring.spring.core.model;

public class Reservation {

	private String number;
	private String filmName;
	private Session session;
	private Double cost;
	private User customer;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [number=");
		builder.append(number);
		builder.append(", filmName=");
		builder.append(filmName);
		builder.append(", session=");
		builder.append(session);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", customer=");
		builder.append(customer);
		builder.append("]");
		return builder.toString();
	}

}
