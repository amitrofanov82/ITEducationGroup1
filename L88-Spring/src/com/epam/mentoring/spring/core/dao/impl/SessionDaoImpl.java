package com.epam.mentoring.spring.core.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.spring.core.dao.SessionDao;
import com.epam.mentoring.spring.core.model.Session;

public class SessionDaoImpl implements SessionDao {

	private static final Logger logger = Logger.getLogger(SessionDaoImpl.class);

	@Autowired
	private List<Session> sessions;

	public List<Session> findAll(LocalDateTime time) {
		return sessions.stream().filter(session -> session.getTime().equals(time)).collect(Collectors.toList());
	}

	private void init() {
		logger.info("**** Initialized sessions ****");
		sessions.forEach(session -> logger.info("Session: " + session));
	}

}
