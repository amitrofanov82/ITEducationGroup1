package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.dao.INewsDao;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 * 
 * 
 *         Contains all additional methods for news service
 */
public interface INewsService extends GenericService<News> {

	/**
	 * Delegate method for persistence layer. See {@link INewsDao}
	 * 
	 * @param newsId
	 * @param authorId
	 * @throws ServiceException
	 */
	public void addNewsAuthor(Long newsId, Long authorId)
			throws ServiceException;

	/**
	 * Delegate method for persistence layer. See {@link INewsDao}
	 * 
	 * @param newsId
	 * @param tagIds
	 * @throws ServiceException
	 */
	public void addNewsTags(Long newsId, Long[] tagIds) throws ServiceException;

	/**
	 * Delegate method for persistence layer. See {@link INewsDao}
	 * 
	 * @param authorId
	 * @return news entity
	 * @throws ServiceException
	 */
	public List<News> findByAuthor(Long authorId) throws ServiceException;

	/**
	 * Delegate method for persistence layer. See {@link INewsDao}
	 * 
	 * @param tagIds
	 * @return list of news
	 * @throws ServiceException
	 */
	public List<News> findByTags(Long[] tagIds) throws ServiceException;

	/**
	 * Delegate method for persistence layer. See {@link INewsDao}
	 * 
	 * @return all news count
	 * @throws ServiceException
	 */
	public Long getCount() throws ServiceException;
}