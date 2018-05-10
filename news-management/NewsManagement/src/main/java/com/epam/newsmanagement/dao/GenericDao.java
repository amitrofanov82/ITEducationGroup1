package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Generic interface for dao layer. Supports CRUD operations
 *         </p>
 * @param <T>
 * 
 *            - type of dao object
 */
public interface GenericDao<T> {

	/**
	 * Add dao object in database
	 * 
	 * @param addObject
	 *            - dao object, that added in db
	 * @return new id
	 * @throws DaoException
	 */
	Long add(T addObject) throws DaoException;

	/**
	 * Load all objects of required type from database
	 * 
	 * @return List of required objects
	 * @throws DaoException
	 */
	List<T> loadAll() throws DaoException;

	/**
	 * Load single object from database by id
	 * 
	 * @param id
	 * @return required object
	 * @throws DaoException
	 */
	T load(Long id) throws DaoException;

	/**
	 * Delete object in database, that id in identifiers
	 * 
	 * @param identifiers
	 * @throws DaoException
	 */
	void delete(Long[] identifiers) throws DaoException;

	/**
	 * Update dao object in database
	 * 
	 * @param updateObject
	 *            - dao object, that will update
	 * @throws DaoException
	 */
	void update(T updateObject) throws DaoException;

}
