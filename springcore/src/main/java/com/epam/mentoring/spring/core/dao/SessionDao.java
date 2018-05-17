package com.epam.mentoring.spring.core.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.mentoring.spring.core.model.Session;

public interface SessionDao {

	public List<Session> findAll(LocalDateTime time);
}
