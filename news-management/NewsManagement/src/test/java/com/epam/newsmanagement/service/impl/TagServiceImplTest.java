package com.epam.newsmanagement.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.newsmanagement.dao.impl.TagDaoImpl;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         TagDaoImpl class test
 *         </p>
 */
@RunWith(MockitoJUnitRunner.class)
public class TagServiceImplTest {

	@Mock
	private TagDaoImpl tagDao;

	@InjectMocks
	private TagServiceImpl tagService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(tagService);
	}

	/**
	 * <p>
	 * Test, that when TagServiceImpl call method saveOrUpdate and tag entity id
	 * isn't set , then TagDaoImpl will call add method.
	 * </p>
	 * 
	 */
	@Test
	public void testAdd() throws ServiceException, DaoException {
		Tag tag = new Tag();
		when(tagDao.add(tag)).thenReturn(1L);
		Long tagId = tagService.saveOrUpdate(tag);
		verify(tagDao).add(tag);
		assertEquals(new Long(1L), tagId);
	}

	/**
	 * <p>
	 * Test, that when TagServiceImpl call method saveOrUpdate and tag entity id
	 * = 1 , then TagDaoImpl will call update method.
	 * </p>
	 * 
	 */
	@Test
	public void testUpdate() throws ServiceException, DaoException {
		Tag tag = new Tag();
		tag.setId(1L);
		tagService.saveOrUpdate(tag);
		verify(tagDao).update(tag);
	}

	/**
	 * <p>
	 * Checks, that when in loadAll method TagDaoImpl throw DaoException, than
	 * TagServiceImpl throw ServiceException
	 * </p>
	 */
	@Test(expected = ServiceException.class)
	public void testLoadAllFailure() throws ServiceException, DaoException {
		when(tagDao.loadAll()).thenThrow(new DaoException("dao exception"));
		tagService.loadAll();
	}

	/**
	 * <p>
	 * Tests, that when TagServiceImpl loadAll() method calls with any long
	 * parameter, than TagDaoImpl loadAll() calls once.
	 * </p>
	 */
	@Test
	public void testLoadAllSuccessful() throws ServiceException, DaoException {
		List<Tag> expected = new ArrayList<Tag>();
		when(tagDao.loadAll()).thenReturn(expected);
		List<Tag> actual = tagService.loadAll();
		verify(tagDao, times(1)).loadAll();
		assertTrue(actual.isEmpty());
	}

	/**
	 * <p>
	 * Checks, that when TagDaoImpl load method returns Tag with id = 1, than
	 * TagServiceImpl returns Tag with id = 1.
	 * </p>
	 */
	@Test
	public void testLoad() throws ServiceException, DaoException {
		Tag tag = new Tag();
		tag.setId(1L);
		when(tagDao.load(anyLong())).thenReturn(tag);
		Tag newTag = tagService.load(anyLong());
		assertEquals(Long.valueOf(1), newTag.getId());
	}

	/**
	 * <p>
	 * Tests, that when TagServiceImpl delete method calls, than TagDaoImpl
	 * delete() calls once.
	 * </p>
	 */
	@Test
	public void testDelete() throws ServiceException, DaoException {
		tagService.delete(any(Long[].class));
		verify(tagDao, times(1)).delete(any(Long[].class));
	}

	/**
	 * <p>
	 * Tests, that when TagServiceImpl getAllNewsTags() method calls with any
	 * long parameter, than TagDaoImpl getAllNewsTags() calls once.
	 * </p>
	 */
	@Test
	public void testGetAllNewsTags() throws ServiceException, DaoException {
		List<Tag> expected = new ArrayList<Tag>();
		when(tagDao.getAllNewsTags(anyLong())).thenReturn(expected);
		List<Tag> actual = tagService.getAllNewsTags(anyLong());
		verify(tagDao, times(1)).getAllNewsTags(anyLong());
		assertTrue(actual.isEmpty());
	}

}
