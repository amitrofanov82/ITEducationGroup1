package com.epam.newsmanagement.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doThrow;
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

import com.epam.newsmanagement.dao.impl.NewsDaoImpl;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         NewsDaoImpl class test
 *         </p>
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsServiceImplTest {

	@Mock
	private NewsDaoImpl newsDao;

	@InjectMocks
	private NewsServiceImpl newsService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(newsService);
	}

	/**
	 * <p>
	 * Test, that when NewsServiceImpl call method saveOrUpdate and news entity
	 * id isn't set, then NewsDaoImpl will call add method.
	 * </p>
	 * 
	 */
	@Test
	public void testAdd() throws ServiceException, DaoException {
		News news = new News();
		when(newsDao.add(news)).thenReturn(1L);
		Long newsId = newsService.saveOrUpdate(news);
		verify(newsDao).add(news);
		assertEquals(new Long(1L), newsId);
	}

	/**
	 * <p>
	 * Test, that when NewsServiceImpl call method saveOrUpdate and news entity
	 * id = 1 , then NewsDaoImpl will call update method.
	 * </p>
	 * 
	 */
	@Test
	public void testUpdate() throws ServiceException, DaoException {
		News news = new News();
		news.setId(1L);
		newsService.saveOrUpdate(news);
		verify(newsDao).update(news);
	}

	/**
	 * <p>
	 * Checks, that when in loadAll method NewsDaoImpl throw DaoException, than
	 * NewsServiceImpl throw ServiceException
	 * </p>
	 */
	@Test(expected = ServiceException.class)
	public void testLoadAllFailure() throws ServiceException, DaoException {
		when(newsDao.loadAll()).thenThrow(new DaoException("dao exception"));
		newsService.loadAll();
	}

	/**
	 * <p>
	 * Tests, that when NewsServiceImpl loadAll method calls, than NewsDaoImpl
	 * loadAll calls once.
	 * </p>
	 */
	@Test
	public void testLoadAllSuccessful() throws ServiceException, DaoException {
		List<News> expected = new ArrayList<News>();
		when(newsDao.loadAll()).thenReturn(expected);
		List<News> actual = newsService.loadAll();
		verify(newsDao, times(1)).loadAll();
		assertTrue(actual.isEmpty());
	}

	/**
	 * <p>
	 * Checks, that when NewsDaoImpl load method returns News with id = 1, than
	 * NewsServiceImpl returns News with id = 1.
	 * </p>
	 */
	@Test
	public void testLoad() throws ServiceException, DaoException {
		News news = new News();
		news.setId(1L);
		when(newsDao.load(anyLong())).thenReturn(news);
		News otherNews = newsService.load(anyLong());
		assertEquals(Long.valueOf(1), otherNews.getId());
	}

	/**
	 * <p>
	 * Tests, that when NewsServiceImpl delete method calls, than NewsDaoImpl
	 * delete() calls once.
	 * </p>
	 */
	@Test
	public void testDelete() throws ServiceException, DaoException {
		newsService.delete(any(Long[].class));
		verify(newsDao, times(1)).delete(any(Long[].class));
	}

	/**
	 * <p>
	 * Checks, that when in addNewsAuthor method NewsDaoImpl throw DaoException,
	 * than NewsServiceImpl throw ServiceException
	 * </p>
	 */
	@Test(expected = ServiceException.class)
	public void testAddNewsAuthorFailure() throws ServiceException,
			DaoException {
		doThrow(DaoException.class).when(newsDao).addNewsAuthor(anyLong(),
				anyLong());
		newsService.addNewsAuthor(anyLong(), anyLong());
	}

	/**
	 * <p>
	 * Tests, that when NewsServiceImpl addNewsAuthor method calls, than
	 * NewsDaoImpl addNewsAuthor calls once.
	 * </p>
	 */
	@Test
	public void testAddNewsAuthorSuccessful() throws ServiceException,
			DaoException {
		newsService.addNewsAuthor(anyLong(), anyLong());
		verify(newsDao, times(1)).addNewsAuthor(anyLong(), anyLong());
	}

	/**
	 * <p>
	 * Checks, that when in addNewsTag method NewsDaoImpl throw DaoException,
	 * than NewsServiceImpl throw ServiceException
	 * </p>
	 */
	@Test(expected = ServiceException.class)
	public void testAddNewsTagsFailure() throws ServiceException, DaoException {
		doThrow(DaoException.class).when(newsDao).addNewsTags(anyLong(),
				any(Long[].class));
		newsService.addNewsTags(anyLong(), any(Long[].class));
	}

	/**
	 * <p>
	 * Tests, that when NewsServiceImpl addNewsTags method calls, than
	 * NewsDaoImpl findByTags() calls once.
	 * </p>
	 */
	@Test
	public void testAddNewsTagsSuccessful() throws ServiceException,
			DaoException {
		newsService.addNewsTags(anyLong(), any(Long[].class));
		verify(newsDao, times(1)).addNewsTags(anyLong(), any(Long[].class));
	}

	/**
	 * <p>
	 * Tests, that when NewsServiceImpl findNewsByAuthor method calls, than
	 * NewsDaoImpl findNewsByAuthor() calls once.
	 * </p>
	 */
	@Test
	public void testFindByAuthor() throws ServiceException, DaoException {
		List<News> expected = new ArrayList<News>();
		when(newsDao.findByAuthor(anyLong())).thenReturn(expected);
		List<News> actual = newsService.findByAuthor(anyLong());
		verify(newsDao, times(1)).findByAuthor(anyLong());
		assertTrue(actual.isEmpty());
	}

	/**
	 * <p>
	 * Tests, that when NewsServiceImpl findByTags method calls, than
	 * NewsDaoImpl findByTags() calls once.
	 * </p>
	 */
	@Test
	public void testFindByTags() throws ServiceException, DaoException {
		List<News> expected = new ArrayList<News>();
		when(newsDao.findByTags(any(Long[].class))).thenReturn(expected);
		List<News> actual = newsService.findByTags(any(Long[].class));
		verify(newsDao, times(1)).findByTags(any(Long[].class));
		assertTrue(actual.isEmpty());
	}

	/**
	 * <p>
	 * Tests, that when NewsServiceImpl getCount method calls, than NewsDaoImpl
	 * getCount() calls once.
	 * </p>
	 */
	@Test
	public void testGetCount() throws ServiceException, DaoException {
		Long expected = 3L;
		when(newsDao.getCount()).thenReturn(expected);
		Long actual = newsService.getCount();
		verify(newsDao, times(1)).getCount();
		assertEquals(expected, actual);
	}

}
