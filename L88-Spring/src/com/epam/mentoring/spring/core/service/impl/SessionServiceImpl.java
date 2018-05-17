package com.epam.mentoring.spring.core.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentoring.spring.core.dao.SessionDao;
import com.epam.mentoring.spring.core.exception.ServiceException;
import com.epam.mentoring.spring.core.model.Session;
import com.epam.mentoring.spring.core.service.SessionService;

public class SessionServiceImpl implements SessionService {

	private static final Logger logger = Logger.getLogger(SessionServiceImpl.class);

	@Autowired
	private SessionDao sessionDao;
	
	public SessionServiceImpl(SessionDao sessionDao) {
		this.sessionDao=sessionDao;
	}
	
	public SessionServiceImpl() {
	}

	public List<Session> findAll(LocalDateTime time) {
		if (time == null) {
			logger.error("Illegal argument. Cannot find sessions: time is null");
			throw new ServiceException("Cannot find sessions");
		}
		return sessionDao.findAll(time);
	}

}
