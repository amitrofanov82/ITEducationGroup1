package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dao.IAuthorDao;
import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 * 
 * 
 *         Contains all additional methods for author service
 */
public interface IAuthorService extends GenericService<Author> {

	/**
	 * Delegate method for persistence layer. See {@link IAuthorDao}
	 * 
	 * @param newsId
	 * @return author entity
	 * @throws ServiceException
	 */
	public Author getByNewsId(Long newsId) throws ServiceException;

}