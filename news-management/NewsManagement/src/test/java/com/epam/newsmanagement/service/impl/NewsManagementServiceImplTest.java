package com.epam.newsmanagement.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.NewsVO;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.ServiceException;

/**
 * @author Mikhail_Sadouski
 *         <p>
 *         NewsManagementServiceImpl class test
 *         </p>
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsManagementServiceImplTest {

	@Mock
	private AuthorServiceImpl authorService;
	@Mock
	private CommentServiceImpl commentService;
	@Mock
	private TagServiceImpl tagService;
	@Mock
	private NewsServiceImpl newsService;

	@InjectMocks
	private NewsManagementServiceImpl newsManagementService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(newsManagementService);
	}

	/**
	 * Save news test
	 */
	@Test
	public void saveNews() throws ServiceException {
		News news = new News();
		Long expectedId = 1L;
		when(newsService.saveOrUpdate(news)).thenReturn(expectedId);
		Long authorId = 1L;
		Long[] tagIds = new Long[] { 1L, 2L };
		Long actualId = newsManagementService.saveNews(news, authorId, tagIds);
		verify(newsService, times(1)).saveOrUpdate(news);
		verify(newsService, times(1)).addNewsAuthor(actualId, authorId);
		verify(newsService, times(1)).addNewsTags(actualId, tagIds);
		assertEquals(expectedId, actualId);
	}

	/**
	 * Load news test
	 */
	@Test
	public void loadNews() throws ServiceException {
		NewsVO expected = new NewsVO();
		News news = new News();
		news.setShortText("news");
		Author author = new Author();
		author.setName("Pushkin");
		List<Comment> comments = new ArrayList<Comment>();
		List<Tag> tagList = new ArrayList<Tag>();
		expected.setAuthor(author);
		expected.setComments(comments);
		expected.setNews(news);
		expected.setTags(tagList);
		Long newsId = 1L;
		when(newsService.load(newsId)).thenReturn(news);
		when(tagService.getAllNewsTags(newsId)).thenReturn(tagList);
		when(authorService.getByNewsId(newsId)).thenReturn(author);
		when(commentService.getAllNewsComments(newsId)).thenReturn(comments);
		NewsVO actual = newsManagementService.loadNews(newsId);
		verify(newsService, times(1)).load(newsId);
		verify(tagService, times(1)).getAllNewsTags(newsId);
		verify(authorService, times(1)).getByNewsId(newsId);
		verify(commentService, times(1)).getAllNewsComments(newsId);
		assertTrue(expected.equals(actual));
	}

	/**
	 * Find news by author test
	 */
	@Test
	public void findNewsByAuthor() throws ServiceException {
		List<NewsVO> result = newsManagementService
				.findNewsByAuthor(new Author());
		verify(newsService, times(1)).findByAuthor(anyLong());
		assertTrue(null != result);
	}

	/**
	 * Find news by tags test
	 */
	@Test
	public void findNewsByTags() throws ServiceException {
		Long[] tagIds = new Long[] { 1L };
		List<NewsVO> result = newsManagementService.findNewsByTags(tagIds);
		verify(newsService, times(1)).findByTags(tagIds);
		assertTrue(null != result);
	}

	/**
	 * load all news
	 */
	@Test
	public void loadAllNews() throws ServiceException {
		List<NewsVO> result = newsManagementService.loadAllNews();
		verify(newsService, times(1)).loadAll();
		assertTrue(null != result);
	}

}
