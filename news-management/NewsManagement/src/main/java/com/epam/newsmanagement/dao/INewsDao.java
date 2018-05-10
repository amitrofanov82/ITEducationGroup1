package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *
 *         Contains all additional methods for news dao
 */
public interface INewsDao extends GenericDao<News> {

	/**
	 * Binds news with author by ids
	 * 
	 * @param newsId
	 * @param authorId
	 * @throws DaoException
	 */
	public void addNewsAuthor(Long newsId, Long authorId) throws DaoException;

	/**
	 * Binds news with tags by newsId and tag ids
	 * 
	 * @param newsId
	 * @param tagIds
	 * @throws DaoException
	 */
	public void addNewsTags(Long newsId, Long[] tagIds) throws DaoException;

	/**
	 * Finds all news by it's author
	 * 
	 * @param authorId
	 * @return news entity object
	 * @throws DaoException
	 */
	public List<News> findByAuthor(Long authorId) throws DaoException;

	/**
	 * Find all news by tag ids array
	 * 
	 * @param tagIds
	 * @return news list
	 * @throws DaoException
	 */
	public List<News> findByTags(Long[] tagIds) throws DaoException;

	/**
	 * Get all news count
	 * 
	 * @return count
	 * @throws DaoException
	 */
	public Long getCount() throws DaoException;

}
