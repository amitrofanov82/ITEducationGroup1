package com.epam.newsmanagement.service;

import java.util.List;

import com.epam.newsmanagement.dao.ITagDao;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 * 
 * 
 *         Contains all additional methods for tag service
 */
public interface ITagService extends GenericService<Tag> {

	/**
	 * Delegate method for persistence layer. See {@link ITagDao}
	 * 
	 * @param newsId
	 * @return list of tags
	 * @throws ServiceException
	 */
	public List<Tag> getAllNewsTags(Long newsId) throws ServiceException;

}