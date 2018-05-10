package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Generic interface for service layer. Delegate CRUD operations for
 *         persistence layer
 *         </p>
 * @param <T>
 * 
 *            - type of entity object
 */
public interface GenericService<T> {

	/**
	 * Update exist entity or create new if id = 0
	 * 
	 * @param entity
	 * @return id
	 * @throws ServiceException
	 */
	Long saveOrUpdate(T entity) throws ServiceException;

	/**
	 * Load all entities of required type
	 * 
	 * @return List of required entities
	 * @throws ServiceException
	 */
	List<T> loadAll() throws ServiceException;

	/**
	 * Load single entity by it's id
	 * 
	 * @param id
	 * @return entity object
	 * @throws ServiceException
	 */
	T load(Long id) throws ServiceException;

	/**
	 * Delete entities with id, that in identifiers
	 * 
	 * @param identifiers
	 * @throws ServiceException
	 */
	void delete(Long[] identifiers) throws ServiceException;

}