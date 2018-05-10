package com.epam.newsmanagement.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.newsmanagement.dao.ICommentDao;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.ICommentService;

/**
 * @author Mikhail_Sadouski
 * 
 *         <p>
 *         Comment service implementation. Realized additional functions of
 *         {@link ICommentService}
 *         </p>
 */
public class CommentServiceImpl implements ICommentService {

	private static final Logger logger = Logger
			.getLogger(CommentServiceImpl.class);
	private ICommentDao commentDao;

	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}

	/**
	 * Add comment if it's not persist and update else
	 * 
	 * @param comment
	 *            object
	 */
	@Override
	public Long saveOrUpdate(Comment comment) throws ServiceException {
		Long id = 0L;
		try {
			if (null == comment.getId()) {
				id = commentDao.add(comment);
			} else {
				commentDao.update(comment);
			}
		} catch (DaoException e) {
			logger.error("Can't save comment: " + e.getMessage(), e);
			throw new ServiceException("Can't save comment: " + e.getMessage(),
					e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link ICommentDao}
	 */
	@Override
	public List<Comment> loadAll() throws ServiceException {
		try {
			return commentDao.loadAll();
		} catch (DaoException e) {
			logger.error("Can't load comment list: " + e.getMessage(), e);
			throw new ServiceException("Can't load  comment list: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link ICommentDao}
	 */
	@Override
	public Comment load(Long commentId) throws ServiceException {
		try {
			return commentDao.load(commentId);
		} catch (DaoException e) {
			logger.error("Can't load comment: " + e.getMessage(), e);
			throw new ServiceException("Can't load comment: " + e.getMessage(),
					e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link ICommentDao}
	 */
	@Override
	public void delete(Long[] commentIds) throws ServiceException {
		try {
			commentDao.delete(commentIds);
		} catch (DaoException e) {
			logger.error("Can't delete comments: " + e.getMessage(), e);
			throw new ServiceException("Can't delete comments :"
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link ICommentDao}
	 * 
	 * @param newsId
	 * @return list of comments
	 * @throws ServiceException
	 */
	@Override
	public List<Comment> getAllNewsComments(Long newsId)
			throws ServiceException {
		try {
			return commentDao.getAllNewsComments(newsId);
		} catch (DaoException e) {
			logger.error("Can't get all news comments: " + e.getMessage(), e);
			throw new ServiceException("Can't get all news comments: "
					+ e.getMessage(), e);
		}
	}

}