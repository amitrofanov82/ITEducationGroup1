package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *
 *         Contains all additional methods for author dao
 */
public interface IAuthorDao extends GenericDao<Author> {

	/**
	 * Get news author by newsId
	 * 
	 * @param newsId
	 * @return author entity
	 * @throws DaoException
	 */
	public Author getByNewsId(Long newsId) throws DaoException;

}
