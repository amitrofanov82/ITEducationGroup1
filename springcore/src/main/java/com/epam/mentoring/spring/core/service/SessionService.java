package com.epam.mentoring.spring.core.service;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.mentoring.spring.core.model.Session;

public interface SessionService {

	public List<Session> findAll(LocalDateTime time);

}
