package com.epam.newsmanagement.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.newsmanagement.dao.IAuthorDao;
import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;
import com.epam.newsmanagement.service.IAuthorService;

/**
 * @author Mikhail_Sadouski
 * 
 *         <p>
 *         Author service implementation. Realized additional functions of
 *         {@link IAuthorService}
 *         </p>
 */
public class AuthorServiceImpl implements IAuthorService {

	private static final Logger logger = Logger
			.getLogger(AuthorServiceImpl.class);
	private IAuthorDao authorDao;

	public void setAuthorDao(IAuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	/**
	 * Add author if it's not persist and update else
	 * 
	 * @param author
	 *            object
	 */
	@Override
	public Long saveOrUpdate(Author author) throws ServiceException {
		Long id = 0L;
		try {
			if (null == author.getId()) {
				id = authorDao.add(author);
			} else {
				authorDao.update(author);
			}
		} catch (DaoException e) {
			logger.error("Can't save author: " + e.getMessage(), e);
			throw new ServiceException("Can't save author: " + e.getMessage(),
					e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link IAuthorDao}
	 */
	@Override
	public List<Author> loadAll() throws ServiceException {
		try {
			return authorDao.loadAll();
		} catch (DaoException e) {
			logger.error("Can't load author list: " + e.getMessage(), e);
			throw new ServiceException("Can't load  author list: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link IAuthorDao}
	 */
	@Override
	public Author load(Long authorId) throws ServiceException {
		try {
			return authorDao.load(authorId);
		} catch (DaoException e) {
			logger.error("Can't load author: " + e.getMessage(), e);
			throw new ServiceException("Can't load author: " + e.getMessage(),
					e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link IAuthorDao}
	 */
	@Override
	public void delete(Long[] authorIds) throws ServiceException {
		try {
			authorDao.delete(authorIds);
		} catch (DaoException e) {
			logger.error("Can't delete author: " + e.getMessage(), e);
			throw new ServiceException("Can't delete authors :"
					+ e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IAuthorDao}.
	 * 
	 * @param newsId
	 * @return author entity
	 * @throws ServiceException
	 */
	@Override
	public Author getByNewsId(Long newsId) throws ServiceException {
		try {
			return authorDao.getByNewsId(newsId);
		} catch (DaoException e) {
			logger.error("Can't get author by news id: " + e.getMessage(), e);
			throw new ServiceException("Can't get author by news id: "
					+ e.getMessage(), e);
		}
	}

}