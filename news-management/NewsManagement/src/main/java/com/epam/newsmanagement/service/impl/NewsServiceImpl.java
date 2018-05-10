package com.epam.newsmanagement.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.newsmanagement.dao.INewsDao;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.INewsService;

/**
 * @author Mikhail_Sadouski
 * 
 *         <p>
 *         Author service implementation. Realized additional functions of
 *         {@link INewsService}
 *         </p>
 */
public class NewsServiceImpl implements INewsService {

	private static final Logger logger = Logger
			.getLogger(NewsServiceImpl.class);
	private INewsDao newsDao;

	public void setNewsDao(INewsDao newsDao) {
		this.newsDao = newsDao;
	}

	/**
	 * Add news if it's not persist and update else
	 * 
	 * @param news
	 *            object
	 */
	@Override
	public Long saveOrUpdate(News news) throws ServiceException {
		Long id = 0L;
		try {
			if (null == news.getId()) {
				id = newsDao.add(news);
			} else {
				newsDao.update(news);
			}
		} catch (DaoException e) {
			logger.error("Can't save news: " + e.getMessage(), e);
			throw new ServiceException("Can't save news: " + e.getMessage(), e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link INewsDao}
	 */
	@Override
	public List<News> loadAll() throws ServiceException {
		try {
			return newsDao.loadAll();
		} catch (DaoException e) {
			logger.error("Can't load news list: " + e.getMessage(), e);
			throw new ServiceException("Can't load  news list: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link INewsDao}
	 */
	@Override
	public News load(Long newsId) throws ServiceException {
		try {
			return newsDao.load(newsId);
		} catch (DaoException e) {
			logger.error("Can't load news: " + e.getMessage(), e);
			throw new ServiceException("Can't load news: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link INewsDao}
	 */
	@Override
	public void delete(Long[] newsIds) throws ServiceException {
		try {
			newsDao.delete(newsIds);
		} catch (DaoException e) {
			logger.error("Can't delete news: " + e.getMessage(), e);
			throw new ServiceException("Can't delete news :" + e.getMessage(),
					e);
		}
	}

	/**
	 * Delegate method for {@link INewsDao}
	 * 
	 * @param newsId
	 * @param authorId
	 * @throws ServiceException
	 */
	@Override
	public void addNewsAuthor(Long newsId, Long authorId)
			throws ServiceException {
		try {
			newsDao.addNewsAuthor(newsId, authorId);
		} catch (DaoException e) {
			logger.error("Can't add news author: " + e.getMessage(), e);
			throw new ServiceException("Can't add news author: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link INewsDao}
	 * 
	 * @param newsId
	 * @param tagIds
	 * @throws ServiceException
	 */
	@Override
	public void addNewsTags(Long newsId, Long[] tagIds) throws ServiceException {

		try {
			newsDao.addNewsTags(newsId, tagIds);
		} catch (DaoException e) {
			logger.error("Can't add  news tags: " + e.getMessage(), e);
			throw new ServiceException(
					"Can't add news tags: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link INewsDao}
	 * 
	 * @param authorId
	 * @return news entity
	 * @throws ServiceException
	 */
	@Override
	public List<News> findByAuthor(Long authorId) throws ServiceException {
		try {
			return newsDao.findByAuthor(authorId);
		} catch (DaoException e) {
			logger.error("Can't find news by author: " + e.getMessage(), e);
			throw new ServiceException("Can't find news by author: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link INewsDao}
	 * 
	 * @param tagIds
	 * @return list of news
	 * @throws ServiceException
	 */
	@Override
	public List<News> findByTags(Long[] tagIds) throws ServiceException {
		try {
			return newsDao.findByTags(tagIds);
		} catch (DaoException e) {
			logger.error("Can't find news by tags: " + e.getMessage(), e);
			throw new ServiceException("Can't find news by tags: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link INewsDao}
	 * 
	 * @return all news count
	 * @throws ServiceException
	 */
	@Override
	public Long getCount() throws ServiceException {
		try {
			return newsDao.getCount();
		} catch (DaoException e) {
			logger.error("Can't get all news count: " + e.getMessage(), e);
			throw new ServiceException("Can't get all news count: "
					+ e.getMessage(), e);
		}
	}

}