package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *
 *         Contains all additional methods for tag dao
 */
public interface ITagDao extends GenericDao<Tag> {

	/**
	 * Get all news tags by newsId
	 * 
	 * @param newsId
	 * @return list of tags
	 * @throws DaoException
	 */
	public List<Tag> getAllNewsTags(Long newsId) throws DaoException;
}
