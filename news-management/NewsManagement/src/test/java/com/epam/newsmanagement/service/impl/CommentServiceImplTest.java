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

import com.epam.newsmanagement.dao.impl.CommentDaoImpl;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         CommentServiceImpl class test
 *         </p>
 */
@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {

	@Mock
	private CommentDaoImpl commentDao;

	@InjectMocks
	private CommentServiceImpl commentService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(commentService);
	}

	/**
	 * <p>
	 * Test, that when CommentServiceImpl call method saveOrUpdate and comment
	 * entity id isn't set , then CommentDaoImpl will call add method.
	 * </p>
	 * 
	 */
	@Test
	public void testAdd() throws ServiceException, DaoException {
		Comment comment = new Comment();
		when(commentDao.add(comment)).thenReturn(1L);
		Long commentId = commentService.saveOrUpdate(comment);
		verify(commentDao).add(comment);
		assertEquals(new Long(1L), commentId);
	}

	/**
	 * <p>
	 * Test, that when CommentServiceImpl call method saveOrUpdate and comment
	 * entity id = 1 , then AuthorDaoImpl will call update method.
	 * </p>
	 * 
	 */
	@Test
	public void testUpdate() throws ServiceException, DaoException {
		Comment comment = new Comment();
		comment.setId(1L);
		commentService.saveOrUpdate(comment);
		verify(commentDao).update(comment);
	}

	/**
	 * <p>
	 * Checks, that when in loadAll method CommentDaoImpl throw DaoException,
	 * than CommentServiceImpl throw ServiceException
	 * </p>
	 */
	@Test(expected = ServiceException.class)
	public void testLoadAllFailure() throws ServiceException, DaoException {
		when(commentDao.loadAll()).thenThrow(new DaoException("dao exception"));
		commentService.loadAll();
	}

	/**
	 * <p>
	 * Tests, that when CommentServiceImpl load all method calls, than
	 * CommentDaoImpl load all calls once.
	 * </p>
	 */
	@Test
	public void testLoadAllSuccessful() throws ServiceException, DaoException {
		List<Comment> expected = new ArrayList<Comment>();
		when(commentDao.loadAll()).thenReturn(expected);
		List<Comment> actual = commentService.loadAll();
		verify(commentDao, times(1)).loadAll();
		assertTrue(actual.isEmpty());
	}

	/**
	 * <p>
	 * Checks, that when CommentDaoImpl load method returns Comment with id = 1,
	 * than CommentServiceImpl returns Comment with id = 1.
	 * </p>
	 */
	@Test
	public void testLoad() throws ServiceException, DaoException {
		Comment comment = new Comment();
		comment.setId(1L);
		when(commentDao.load(anyLong())).thenReturn(comment);
		Comment newComment = commentService.load(anyLong());
		assertEquals(Long.valueOf(1), newComment.getId());
	}

	/**
	 * <p>
	 * Tests, that when CommentServiceImpl delete method calls, than
	 * CommentDaoImpl delete() calls once.
	 * </p>
	 */
	@Test
	public void testDelete() throws ServiceException, DaoException {
		commentService.delete(any(Long[].class));
		verify(commentDao, times(1)).delete(any(Long[].class));
	}

	/**
	 * <p>
	 * Tests, that when CommentServiceImpl getAllNewsComments() method calls
	 * with any long parameter, than CommentDaoImpl getAllNewsComments() calls
	 * once.
	 * </p>
	 */
	@Test
	public void testGetAllNewsComments() throws ServiceException, DaoException {
		List<Comment> expected = new ArrayList<Comment>();
		when(commentDao.getAllNewsComments(anyLong())).thenReturn(expected);
		List<Comment> actual = commentService.getAllNewsComments(anyLong());
		verify(commentDao, times(1)).getAllNewsComments(anyLong());
		assertTrue(actual.isEmpty());
	}
}
