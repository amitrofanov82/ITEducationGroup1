package com.epam.newsmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.NewsVO;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.INewsManagementService;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Contains all service methods and delegates them for implementation
 *         classes.
 *         </p>
 */
public class NewsManagementServiceImpl implements INewsManagementService {

	private static final Logger logger = Logger
			.getLogger(NewsManagementServiceImpl.class);
	private AuthorServiceImpl authorService;
	private CommentServiceImpl commentService;
	private TagServiceImpl tagService;
	private NewsServiceImpl newsService;

	public void setAuthorService(AuthorServiceImpl authorService) {
		this.authorService = authorService;
	}

	public void setCommentService(CommentServiceImpl commentService) {
		this.commentService = commentService;
	}

	public void setTagService(TagServiceImpl tagService) {
		this.tagService = tagService;
	}

	public void setNewsService(NewsServiceImpl newsService) {
		this.newsService = newsService;
	}

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
	@Transactional(rollbackFor = ServiceException.class)
	@Override
	public Long saveNews(News news, Long authorId, Long[] tagIds)
			throws ServiceException {
		try {
			Long newsId = newsService.saveOrUpdate(news);
			newsService.addNewsAuthor(newsId, authorId);
			newsService.addNewsTags(newsId, tagIds);
			return newsId;
		} catch (ServiceException e) {
			logger.error("Can't save news: " + e.getMessage(), e);
			throw new ServiceException("Can't save news: " + e.getMessage(), e);
		}
	}

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
	@Transactional(rollbackFor = ServiceException.class)
	@Override
	public NewsVO loadNews(Long newsId) throws ServiceException {
		try {
			News news = newsService.load(newsId);
			List<Tag> tags = tagService.getAllNewsTags(newsId);
			Author author = authorService.getByNewsId(newsId);
			List<Comment> comments = commentService.getAllNewsComments(newsId);
			NewsVO newsVO = new NewsVO();
			newsVO.setAuthor(author);
			newsVO.setComments(comments);
			newsVO.setTags(tags);
			newsVO.setNews(news);
			return newsVO;
		} catch (ServiceException e) {
			logger.error(
					"Can't load news with tags, comments and author: "
							+ e.getMessage(), e);
			throw new ServiceException(
					"Can't load news with tags, comments and author: "
							+ e.getMessage(), e);
		}
	}

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
	@Transactional(rollbackFor = ServiceException.class)
	@Override
	public List<NewsVO> findNewsByAuthor(Author author) throws ServiceException {
		try {
			List<NewsVO> newsVOs = new ArrayList<NewsVO>();
			List<News> newsList = newsService.findByAuthor(author.getId());
			for (News news : newsList) {
				newsVOs.add(loadNews(news.getId()));
			}
			return newsVOs;
		} catch (ServiceException e) {
			logger.error(
					"Can't find news by author and return news value objects: "
							+ e.getMessage(), e);
			throw new ServiceException(
					"Can't find news by author and return news value objects: "
							+ e.getMessage(), e);
		}
	}

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
	@Transactional(rollbackFor = ServiceException.class)
	@Override
	public List<NewsVO> findNewsByTags(Long[] tagIdList)
			throws ServiceException {
		try {
			List<NewsVO> newsVOs = new ArrayList<NewsVO>();
			List<News> newsList = newsService.findByTags(tagIdList);
			for (News news : newsList) {
				newsVOs.add(loadNews(news.getId()));
			}
			return newsVOs;
		} catch (ServiceException e) {
			logger.error(
					"Can't find news by tags and return news value objects: "
							+ e.getMessage(), e);
			throw new ServiceException(
					"Can't find news by tags and return news value objects: "
							+ e.getMessage(), e);
		}
	}

	/**
	 * <p>
	 * Load all news in database with it's tags, comments and author. Return as
	 * value object list.
	 * </p>
	 *
	 * @return news value objects list
	 * @throws ServiceException
	 */
	@Transactional(rollbackFor = ServiceException.class)
	@Override
	public List<NewsVO> loadAllNews() throws ServiceException {
		try {
			List<NewsVO> newsVOs = new ArrayList<NewsVO>();
			List<News> newsList = newsService.loadAll();
			for (News news : newsList) {
				newsVOs.add(loadNews(news.getId()));
			}
			return newsVOs;
		} catch (ServiceException e) {
			logger.error("Can't load all news and return news value objects: "
					+ e.getMessage(), e);
			throw new ServiceException(
					"Can't load all news and return news value objects: "
							+ e.getMessage(), e);
		}
	}

}
