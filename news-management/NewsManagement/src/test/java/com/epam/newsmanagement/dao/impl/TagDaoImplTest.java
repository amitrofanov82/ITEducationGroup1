package com.epam.newsmanagement.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         TagDaoImpl class test
 *         </p>
 */
@DatabaseSetup(value = "/dao/impl/TagDaoImplTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-database-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class TagDaoImplTest {

	@Autowired
	private TagDaoImpl tagDaoImpl;

	private boolean assertTags(Tag expected, Tag actual) {
		if (expected.getName().equals(actual.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Adding new tag test.
	 */
	@Test
	public void testAdd() throws DaoException {
		Tag tag = new Tag();
		tag.setName("sport");
		Long tagId = tagDaoImpl.add(tag);
		assertTrue(tagId > 0);
	}

	/**
	 * Load tag test.
	 */
	@Test
	public void testLoad() throws DaoException {
		Tag tag = tagDaoImpl.load(1L);
		assertEquals(tag.getName(), "music");
	}

	/**
	 * Update tag test.
	 */
	@Test
	public void testUpdate() throws DaoException {
		Tag expected = tagDaoImpl.load(1L);
		expected.setName("travel");
		tagDaoImpl.update(expected);
		Tag actual = tagDaoImpl.load(1L);
		boolean compareResult = assertTags(expected, actual);
		assertTrue(compareResult);
	}

	/**
	 * Load all tags test.
	 */
	@Test
	public void testLoadAll() throws DaoException {
		List<Tag> tags = tagDaoImpl.loadAll();
		assertEquals(3, tags.size());
	}

	/**
	 * Delete tag test.
	 */
	@Test
	public void testDelete() throws DaoException {
		List<Tag> tags = tagDaoImpl.loadAll();
		assertEquals(3, tags.size());
		tagDaoImpl.delete(new Long[] { 2L, 3L });
		List<Tag> newTags = tagDaoImpl.loadAll();
		assertEquals(1, newTags.size());
	}

	/**
	 * Get tags by news id test.
	 */
	@Test
	public void testGetAllNewsTags() throws DaoException {
		List<Tag> tags = tagDaoImpl.getAllNewsTags(1L);
		assertEquals(2, tags.size());
	}

}
