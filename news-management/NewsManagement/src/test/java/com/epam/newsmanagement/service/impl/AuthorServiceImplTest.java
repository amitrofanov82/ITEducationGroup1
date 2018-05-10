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

import com.epam.newsmanagement.dao.impl.AuthorDaoImpl;
import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         AuthorServiceImplTest
 *         </p>
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {

	@Mock
	private AuthorDaoImpl authorDao;

	@InjectMocks
	private AuthorServiceImpl authorService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(authorService);
	}

	/**
	 * <p>
	 * Test, that when AuthorServiceImpl call method saveOrUpdate and author
	 * entity isn't set , then AuthorDaoImpl will call add method.
	 * </p>
	 * 
	 */
	@Test
	public void testAdd() throws ServiceException, DaoException {
		Author author = new Author();
		when(authorDao.add(author)).thenReturn(1L);
		Long authorId = authorService.saveOrUpdate(author);
		verify(authorDao).add(author);
		assertEquals(new Long(1L), authorId);
	}

	/**
	 * <p>
	 * Test, that when AuthorServiceImpl call method saveOrUpdate and author
	 * entity id = 1 , then AuthorDaoImpl will call update method.
	 * </p>
	 * 
	 */
	@Test
	public void testUpdate() throws ServiceException, DaoException {
		Author author = new Author();
		author.setId(1L);
		authorService.saveOrUpdate(author);
		verify(authorDao).update(author);
	}

	/**
	 * <p>
	 * Checks, that when in loadAll method AuthorDaoImpl throw DaoException,
	 * than AuthorServiceImpl throw ServiceException
	 * </p>
	 */
	@Test(expected = ServiceException.class)
	public void testLoadAllFailure() throws ServiceException, DaoException {
		when(authorDao.loadAll()).thenThrow(new DaoException("dao exception"));
		authorService.loadAll();
	}

	/**
	 * <p>
	 * Test, that when AuthorServiceImpl call method loadAllAuthors , then
	 * AuthorDaoImpl will call loadAll method.
	 * </p>
	 * 
	 */
	@Test
	public void testLoadAllSuccessful() throws ServiceException, DaoException {
		List<Author> expected = new ArrayList<Author>();
		when(authorDao.loadAll()).thenReturn(expected);
		List<Author> actual = authorService.loadAll();
		verify(authorDao).loadAll();
		assertTrue(actual.isEmpty());
	}

	/**
	 * <p>
	 * Checks, that when AuthorDaoImpl load method returns Author with id = 1,
	 * than AuhorServiceImpl returns Author with id = 1.
	 * </p>
	 */
	@Test
	public void testLoad() throws ServiceException, DaoException {
		Author author = new Author();
		author.setId(1L);
		when(authorDao.load(anyLong())).thenReturn(author);
		Author actual = authorService.load(anyLong());
		assertEquals(Long.valueOf(1), actual.getId());
	}

	/**
	 * <p>
	 * Tests, that when AuthorServiceImpl delete method calls, than
	 * AuthorDaoImpl delete() calls once.
	 * </p>
	 */
	@Test
	public void testDelete() throws ServiceException, DaoException {
		authorService.delete(any(Long[].class));
		verify(authorDao, times(1)).delete(any(Long[].class));
	}

	/**
	 * <p>
	 * Checks, that when AuthorDaoImpl getAuthorByNewsId method returns Author
	 * with setting name, than AuhorServiceImpl returns Author with same name.
	 * </p>
	 */
	@Test
	public void testGetByNewsId() throws ServiceException, DaoException {
		String name = "Ivanov Ivan Ivanovich";
		Author author = new Author();
		author.setName(name);
		when(authorDao.getByNewsId(anyLong())).thenReturn(author);
		Author actual = authorService.getByNewsId(anyLong());
		assertEquals(name, actual.getName());
	}

}