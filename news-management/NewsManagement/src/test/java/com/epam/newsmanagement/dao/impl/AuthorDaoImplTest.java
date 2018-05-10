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

import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         AuthorDaoImpl class test
 *         </p>
 */
@DatabaseSetup(value = "/dao/impl/AuthorDaoImplTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-database-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class AuthorDaoImplTest {

	@Autowired
	private AuthorDaoImpl authorDaoImpl;

	private boolean assertAuthors(Author expected, Author actual) {
		if (expected.getName().equals(actual.getName())
				&& expected.getExpired().compareTo(actual.getExpired()) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Adding new author test.
	 */
	@Test
	public void testAdd() throws DaoException {
		Author author = new Author();
		author.setName("Tytchev");
		author.setExpired(new Date());
		Long authorId = authorDaoImpl.add(author);
		assertTrue(authorId > 0);
	}

	/**
	 * Load author test.
	 */
	@Test
	public void testLoad() throws DaoException {
		Author expected = new Author();
		expected.setName("Turgenev");
		expected.setExpired(new Date());
		Long authorId = authorDaoImpl.add(expected);
		expected.setId(authorId);
		Author actual = authorDaoImpl.load(authorId);
		boolean compareResult = assertAuthors(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Update author test.
	 */
	@Test
	public void testUpdate() throws DaoException {
		Author expected = new Author();
		expected.setName("Tytchev");
		expected.setExpired(new Date());
		Long authorId = authorDaoImpl.add(expected);
		expected.setId(authorId);
		expected.setName("Tregubov");
		authorDaoImpl.update(expected);
		Author actual = authorDaoImpl.load(authorId);
		boolean compareResult = assertAuthors(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Load all authors test.
	 */
	@Test
	public void testLoadAll() throws DaoException {
		List<Author> authors = authorDaoImpl.loadAll();
		assertEquals(3, authors.size());
	}

	/**
	 * Delete author test.
	 */
	@Test
	public void testDelete() throws DaoException {
		Author author = new Author();
		author.setName("Horstmann");
		author.setExpired(new Date());
		Long authorId = authorDaoImpl.add(author);
		authorDaoImpl.delete(new Long[] { authorId });
		List<Author> authors = authorDaoImpl.loadAll();
		assertEquals(3, authors.size());
	}

	/**
	 * Get author by news id test.
	 */
	@Test
	public void testGetByNewsId() throws DaoException {
		Author expected = authorDaoImpl.load(1L);
		Author actual = authorDaoImpl.getByNewsId(1L);
		boolean compareResult = assertAuthors(expected, actual);
		assertTrue(compareResult);
	}
}
