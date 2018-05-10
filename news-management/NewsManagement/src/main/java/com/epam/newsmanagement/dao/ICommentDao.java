package com.epam.newsmanagement.dao;

import java.util.List;

import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *
 *         Contains all additional methods for comment dao
 */
public interface ICommentDao extends GenericDao<Comment> {

	/**
	 * Get all news comments by newsId
	 * 
	 * @param newsId
	 * @return list of comments
	 * @throws DaoException
	 */
	public List<Comment> getAllNewsComments(Long newsId) throws DaoException;
}
