package com.epam.newsmanagement.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.exception.DaoException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         NewsDaoImpl class test
 *         </p>
 */
@DatabaseSetup(value = "/dao/impl/NewsDaoImplTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-database-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class NewsDaoImplTest {

	@Autowired
	private NewsDaoImpl newsDaoImpl;

	private boolean assertNews(News expected, News actual) {
		if (expected.getFullText().equals(actual.getFullText())
				&& expected.getShortText().equals(actual.getShortText())
				&& expected.getTitle().equals(actual.getTitle())
				&& expected.getCreationDate().compareTo(
						actual.getCreationDate()) == 0
				&& expected.getModificationDate().compareTo(
						actual.getModificationDate()) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Adding new news test.
	 */
	@Test
	public void testAdd() throws DaoException {
		News news = new News();
		news.setShortText("next short");
		news.setFullText("next full");
		news.setTitle("new title");
		news.setCreationDate(new Date());
		news.setModificationDate(new Date());
		Long newsId = newsDaoImpl.add(news);
		assertTrue(newsId > 0);
	}

	/**
	 * Load news test.
	 */
	@Test
	public void testLoad() throws DaoException {
		News news = newsDaoImpl.load(1L);
		assertEquals(news.getTitle(), "title1");
	}

	@Test
	public void testUpdate() throws DaoException {
		News expected = newsDaoImpl.load(1L);
		expected.setTitle("new title");
		newsDaoImpl.update(expected);
		News actual = newsDaoImpl.load(1L);
		boolean compareResult = assertNews(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Load all news test.
	 */
	@Test
	public void testLoadAll() throws DaoException {
		List<News> news = newsDaoImpl.loadAll();
		assertEquals(3, news.size());
	}

	/**
	 * Delete news test.
	 */
	@Test
	public void testDelete() throws DaoException {
		List<News> news = newsDaoImpl.loadAll();
		assertEquals(3, news.size());
		newsDaoImpl.delete(new Long[] { 2L, 3L });
		List<News> afterNews = newsDaoImpl.loadAll();
		assertEquals(1, afterNews.size());
	}

	/**
	 * Find news by author test.
	 */
	@Test
	public void testFindByAuthor() throws DaoException {
		News expected = newsDaoImpl.load(2L);
		List<News> newsList = newsDaoImpl.findByAuthor(1L);
		News actual = newsList.get(0);
		boolean compareResult = assertNews(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Find news by tags test.
	 */
	@Test
	public void testFindByTags() throws DaoException {
		News expected = newsDaoImpl.load(1L);
		List<News> newsList = newsDaoImpl.findByTags(new Long[] { 1L });
		News actual = newsList.get(0);
		boolean compareResult = assertNews(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Add news author test.
	 */
	@Test
	public void testAddNewsAuthor() throws DaoException {
		newsDaoImpl.addNewsAuthor(1L, 2L);
		News expected = newsDaoImpl.load(1L);
		List<News> newsList = newsDaoImpl.findByAuthor(2L);
		News actual = newsList.get(0);
		boolean compareResult = assertNews(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Add news tags test.
	 */
	@Test
	public void testAddNewsTags() throws DaoException {
		Long[] tagIds = { 2L };
		newsDaoImpl.addNewsTags(1L, tagIds);
		News expected = newsDaoImpl.load(1L);
		List<News> newsList = newsDaoImpl.findByTags(tagIds);
		News actual = newsList.get(0);
		boolean compareResult = assertNews(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Get all news count test.
	 */
	@Test
	public void testGetCount() throws DaoException {
		Long newsCount = newsDaoImpl.getCount();
		assertTrue(newsCount == 3);
	}

}
