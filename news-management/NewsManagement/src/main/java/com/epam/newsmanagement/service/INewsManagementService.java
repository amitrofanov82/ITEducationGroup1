package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.NewsVO;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 * 
 * 
 *         Contains methods for making operations with services in one step.
 */
public interface INewsManagementService {

	/**
	 * <p>
	 * Save news in database news table. Binds news with author in news_author
	 * table. Binds news with tags in news_tag table.
	 * </p>
	 * 
	 * @param news
	 * @param authorId
	 * @param tagIds
	 * @return news id from database
	 * @throws ServiceException
	 */
	Long saveNews(News news, Long authorId, Long[] tagIds)
			throws ServiceException;

	/**
	 * <p>
	 * Load news from database with it's author, tags and comments. Return all
	 * this information in news value object.
	 * </p>
	 * 
	 * @param newsId
	 * @return newsVO object
	 * @throws ServiceException
	 */
	NewsVO loadNews(Long newsId) throws ServiceException;

	/**
	 * <p>
	 * Find all news in database by author. Return this news with it's tags,
	 * comments and author in value object list.
	 * </p>
	 * 
	 * @param author
	 * @return news value objects list
	 * @throws ServiceException
	 */
	List<NewsVO> findNewsByAuthor(Author author) throws ServiceException;

	/**
	 * <p>
	 * Find all news in database by tags. Return this news with it's tags,
	 * comments and author in value object list.
	 * </p>
	 *
	 * @param tagIdList
	 * @return news value objects list
	 * @throws ServiceException
	 */
	List<NewsVO> findNewsByTags(Long[] tagIdList) throws ServiceException;

	/**
	 * <p>
	 * Load all news in database with it's tags, comments and author. Return as
	 * value object list.
	 * </p>
	 *
	 * @return news value objects list
	 * @throws ServiceException
	 */
	List<NewsVO> loadAllNews() throws ServiceException;

}
