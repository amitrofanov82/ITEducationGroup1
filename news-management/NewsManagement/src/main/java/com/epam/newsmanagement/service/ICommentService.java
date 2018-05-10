package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.dao.ICommentDao;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 * 
 * 
 *         Contains all additional methods for comment service
 */
public interface ICommentService extends GenericService<Comment> {

	/**
	 * Delegate method for persistence layer. See {@link ICommentDao}
	 * 
	 * @param newsId
	 * @return list of comments
	 * @throws ServiceException
	 */
	public List<Comment> getAllNewsComments(Long newsId)
			throws ServiceException;

}