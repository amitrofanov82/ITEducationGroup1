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

import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         CommentDaoImpl class test
 *         </p>
 */
@DatabaseSetup(value = "/dao/impl/CommentDaoImplTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-database-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class CommentDaoImplTest {

	@Autowired
	private CommentDaoImpl commentDaoImpl;

	private boolean assertComments(Comment expected, Comment actual) {
		if (expected.getCommentText().equals(actual.getCommentText())
				&& expected.getNewsId() == actual.getNewsId()
				&& expected.getCreationDate().compareTo(
						actual.getCreationDate()) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Adding new comment test.
	 */
	@Test
	public void testAdd() throws DaoException {
		Comment comment = new Comment();
		comment.setNewsId(1L);
		comment.setCommentText("new text");
		comment.setCreationDate(new Date());
		Long commentId = commentDaoImpl.add(comment);
		assertTrue(commentId > 0);
	}

	/**
	 * Load comment test.
	 */
	@Test
	public void testLoad() throws DaoException {
		Comment comment = commentDaoImpl.load(1L);
		assertEquals(comment.getCommentText(), "first comment");
	}

	/**
	 * Update comment test.
	 */
	@Test
	public void testUpdate() throws DaoException {
		Comment comment = commentDaoImpl.load(1L);
		comment.setCommentText("new first comment");
		commentDaoImpl.update(comment);
		Comment newComment = commentDaoImpl.load(1L);
		assertEquals(comment.getCommentText(), newComment.getCommentText());
	}

	/**
	 * Load all comments test.
	 */
	@Test
	public void testLoadAll() throws DaoException {
		List<Comment> comments = commentDaoImpl.loadAll();
		assertEquals(2, comments.size());
	}

	/**
	 * Delete comment test.
	 */
	@Test
	public void testDelete() throws DaoException {
		List<Comment> comments = commentDaoImpl.loadAll();
		assertEquals(2, comments.size());
		commentDaoImpl.delete(new Long[] { 2L });
		Comment expected = commentDaoImpl.load(1L);
		List<Comment> newComments = commentDaoImpl.loadAll();
		Comment actual = newComments.get(0);
		assertEquals(1, newComments.size());
		boolean compareResult = assertComments(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Get comments by news id test.
	 */
	@Test
	public void testGetAllNewsComments() throws DaoException {
		List<Comment> comments = commentDaoImpl.getAllNewsComments(1L);
		assertEquals(2, comments.size());
		Comment expected = commentDaoImpl.load(2L);
		Comment actual = comments.get(1);
		boolean compareResult = assertComments(expected, actual);
		assertTrue(compareResult);
	}

}
