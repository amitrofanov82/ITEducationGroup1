package com.epam.newsmanagement.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.newsmanagement.dao.ITagDao;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.ITagService;

/**
 * @author Mikhail_Sadouski
 * 
 *         <p>
 *         Comment service implementation. Realized additional functions of
 *         {@link ITagService}
 *         </p>
 */
public class TagServiceImpl implements ITagService {

	private static final Logger logger = Logger.getLogger(TagServiceImpl.class);
	private ITagDao tagDao;

	public void setTagDao(ITagDao tagDao) {
		this.tagDao = tagDao;
	}

	/**
	 * Add tag if it's not persist and update else
	 * 
	 * @param tag
	 *            object
	 */
	@Override
	public Long saveOrUpdate(Tag tag) throws ServiceException {
		Long id = 0L;
		try {
			if (null == tag.getId()) {
				id = tagDao.add(tag);
			} else {
				tagDao.update(tag);
			}
		} catch (DaoException e) {
			logger.error("Can't save tag: " + e.getMessage(), e);
			throw new ServiceException("Can't save tag: " + e.getMessage(), e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link ITagDao}
	 */
	@Override
	public List<Tag> loadAll() throws ServiceException {
		try {
			return tagDao.loadAll();
		} catch (DaoException e) {
			logger.error("Can't load tag list: " + e.getMessage(), e);
			throw new ServiceException("Can't load  tag list: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link ITagDao}
	 */
	@Override
	public Tag load(Long tagId) throws ServiceException {
		try {
			return tagDao.load(tagId);
		} catch (DaoException e) {
			logger.error("Can't load tag: " + e.getMessage(), e);
			throw new ServiceException("Can't load tag: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link ITagDao}
	 */
	@Override
	public void delete(Long[] tagIds) throws ServiceException {
		try {
			tagDao.delete(tagIds);
		} catch (DaoException e) {
			logger.error("Can't delete tags: " + e.getMessage(), e);
			throw new ServiceException("Can't delete tags :" + e.getMessage(),
					e);
		}
	}

	/**
	 * Delegate method for {@link ITagDao}
	 * 
	 * @param newsId
	 * @return list of tags
	 * @throws ServiceException
	 */
	@Override
	public List<Tag> getAllNewsTags(Long newsId) throws ServiceException {
		try {
			return tagDao.getAllNewsTags(newsId);
		} catch (DaoException e) {
			logger.error("Can't get all news tags: " + e.getMessage(), e);
			throw new ServiceException("Can't get all news tags: "
					+ e.getMessage(), e);
		}
	}

}