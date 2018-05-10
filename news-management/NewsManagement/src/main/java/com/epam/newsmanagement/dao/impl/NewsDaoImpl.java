package com.epam.newsmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.epam.newsmanagement.dao.INewsDao;
import com.epam.newsmanagement.dao.util.DatabaseUtil;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 * 
 *         <p>
 *         News dao implementation. Works with oracle database
 *         </p>
 */
public class NewsDaoImpl implements INewsDao {

	private static final Logger logger = Logger.getLogger(NewsDaoImpl.class);
	private DataSource dataSource;

	private static final String SQL_DELETE_NEWS_QUERY = "DELETE FROM News WHERE news_id";
	private static final String SQL_SELECT_NEWS_COUNT_QUERY = "SELECT COUNT(*) FROM News";
	private static final String SQL_UPDATE_NEWS_QUERY = "UPDATE News SET short_text=?, full_text=?, "
			+ "title=?, creation_date=?, modification_date=? WHERE news_id= ?";
	private static final String SQL_INSERT_NEWS_QUERY = "INSERT INTO News "
			+ "(news_id, short_text, full_text, title, creation_date, modification_date) "
			+ "VALUES (news_seq.nextval, ?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_NEWS_QUERY = "SELECT news_id, "
			+ "short_text, full_text, title, creation_date, modification_date FROM News WHERE news_id = ?";
	private static final String SQL_SELECT_NEWS_SORTED_BY_COMMENTS_COUNT_QUERY = "SELECT n.news_id, n.short_text,"
			+ " n.full_text, n.title, n.creation_date, n.modification_date FROM News n"
			+ " LEFT JOIN (SELECT news_id, COUNT(*) CNT FROM Comments GROUP BY news_id) c ON n.news_id = c.news_id"
			+ " ORDER BY CNT DESC NULLS LAST";
	private static final String SQL_ADD_NEWS_AUTHOR_QUERY = "INSERT INTO News_Author"
			+ " (news_author_id, news_id, author_id) VALUES (news_author_seq.nextval, ?, ?)";
	private static final String SQL_ADD_NEWS_TAG_QUERY = "INSERT INTO News_Tag (news_tag_id, news_id, tag_id) "
			+ " VALUES (news_tag_seq.nextval, ?, ?)";
	private static final String SQL_SELECT_NEWS_BY_AUTHOR_ID_QUERY = "SELECT News.news_id, "
			+ "News.short_text, News.full_text, News.title, News.creation_date, News.modification_date"
			+ " FROM News JOIN News_Author ON  News.news_id = News_Author.news_id WHERE author_id = ?";
	private static final String SQL_SELECT_NEWS_BY_TAGS_QUERY = "SELECT DISTINCT News.news_id,"
			+ " News.short_text, News.full_text, News.title, News.creation_date, News.modification_date"
			+ " FROM News JOIN News_Tag ON  News.news_id = News_Tag.news_id WHERE tag_id";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Add news object in database
	 * 
	 * @param news
	 * @return news id from database
	 * @throws DaoException
	 */
	@Override
	public Long add(News news) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Long newsId = 0L;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_INSERT_NEWS_QUERY,
					new String[] { "news_id" });
			statement.setString(1, news.getShortText());
			statement.setString(2, news.getFullText());
			statement.setString(3, news.getTitle());
			statement.setTimestamp(4, new java.sql.Timestamp(news
					.getCreationDate().getTime()));
			statement.setDate(5, new java.sql.Date(news.getModificationDate()
					.getTime()));
			int affectedRows = statement.executeUpdate();
			if (affectedRows > 0) {
				rs = statement.getGeneratedKeys();
				if (null != rs && rs.next()) {
					newsId = rs.getLong(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Can't add news" + e.getMessage(), e);
			throw new DaoException("Can't add news" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		news.setId(newsId);
		return newsId;
	}

	/**
	 * Load all news from database
	 * 
	 * @return List of news
	 * @throws DaoException
	 */
	@Override
	public List<News> loadAll() throws DaoException {
		List<News> newsList = new ArrayList<News>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement
					.executeQuery(SQL_SELECT_NEWS_SORTED_BY_COMMENTS_COUNT_QUERY);
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getLong("news_id"));
				news.setShortText(rs.getString("short_text"));
				news.setFullText(rs.getString("full_text"));
				news.setTitle(rs.getString("title"));
				news.setCreationDate(new java.util.Date(rs.getTimestamp(
						"creation_date").getTime()));
				news.setModificationDate(new java.util.Date(rs.getDate(
						"creation_date").getTime()));
				newsList.add(news);
			}
		} catch (SQLException e) {
			logger.error("Can't load all news" + e.getMessage(), e);
			throw new DaoException("Can't load all news" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return newsList;
	}

	/**
	 * Load news from database by id
	 * 
	 * @param newsId
	 * @return news
	 * @throws DaoException
	 */
	@Override
	public News load(Long newsId) throws DaoException {
		News news = new News();
		String sql = SQL_SELECT_NEWS_QUERY;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, newsId);
			rs = statement.executeQuery();
			while (rs.next()) {
				News loadNews = new News();
				loadNews.setId(rs.getLong("news_id"));
				loadNews.setShortText(rs.getString("short_text"));
				loadNews.setFullText(rs.getString("full_text"));
				loadNews.setTitle(rs.getString("title"));
				loadNews.setCreationDate(new java.util.Date(rs.getTimestamp(
						"creation_date").getTime()));
				loadNews.setModificationDate(new java.util.Date(rs.getDate(
						"creation_date").getTime()));
				news = loadNews;
			}
		} catch (SQLException e) {
			logger.error("Can't load news" + e.getMessage(), e);
			throw new DaoException("Can't load news " + e.getMessage() + e, e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return news;
	}

	/**
	 * Delete news in database, that id in identifiers
	 * 
	 * @param newsIds
	 * @throws DaoException
	 */
	@Override
	public void delete(Long[] newsIds) throws DaoException {
		String sql = SQL_DELETE_NEWS_QUERY
				+ DatabaseUtil.buildQueryPart(newsIds);
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			statement.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("Can't delete news" + e.getMessage(), e);
			throw new DaoException("Can't delete news " + e.getMessage() + e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * Update news object in database
	 * 
	 * @param news
	 * @throws DaoException
	 */
	@Override
	public void update(News news) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_UPDATE_NEWS_QUERY);
			statement.setString(1, news.getShortText());
			statement.setString(2, news.getFullText());
			statement.setString(3, news.getTitle());
			statement.setTimestamp(4, new java.sql.Timestamp(news
					.getCreationDate().getTime()));
			statement.setDate(5, new java.sql.Date(news.getModificationDate()
					.getTime()));
			statement.setLong(6, news.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't update news" + e.getMessage(), e);
			throw new DaoException("Can't update news" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * Binds news with author by ids
	 * 
	 * @param newsId
	 * @param authorId
	 * @throws DaoException
	 */
	@Override
	public void addNewsAuthor(Long newsId, Long authorId) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement(SQL_ADD_NEWS_AUTHOR_QUERY);
			preparedStatement.setLong(1, newsId);
			preparedStatement.setLong(2, authorId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't add in News_Author table" + e.getMessage(), e);
			throw new DaoException("Can't add in News_Author table"
					+ e.getMessage(), e);
		} finally {
			DatabaseUtil.close(preparedStatement, connection);
		}
	}

	/**
	 * Binds news with tags by newsId and tag ids
	 * 
	 * @param newsId
	 * @param tagIdList
	 * @throws DaoException
	 */
	@Override
	public void addNewsTags(Long newsId, Long[] tagIds) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		for (int index = 0; index < tagIds.length; index++) {
			try {
				connection = dataSource.getConnection();
				preparedStatement = connection
						.prepareStatement(SQL_ADD_NEWS_TAG_QUERY);
				preparedStatement.setLong(1, newsId);
				preparedStatement.setLong(2, tagIds[index]);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				logger.error("Can't add in News_Tag table" + e.getMessage(), e);
				throw new DaoException("Can't add in News_Tag table"
						+ e.getMessage(), e);
			} finally {
				DatabaseUtil.close(preparedStatement, connection);
			}
		}
	}

	/**
	 * Finds all news by it's author
	 * 
	 * @param authorId
	 * @return news entity object
	 * @throws DaoException
	 */
	@Override
	public List<News> findByAuthor(Long authorId) throws DaoException {
		List<News> newsList = new ArrayList<News>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection
					.prepareStatement(SQL_SELECT_NEWS_BY_AUTHOR_ID_QUERY);
			statement.setLong(1, authorId);
			rs = statement.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getLong("news_id"));
				news.setShortText(rs.getString("short_text"));
				news.setFullText(rs.getString("full_text"));
				news.setTitle(rs.getString("title"));
				news.setCreationDate(new java.util.Date(rs.getTimestamp(
						"creation_date").getTime()));
				news.setModificationDate(new java.util.Date(rs.getDate(
						"creation_date").getTime()));
				newsList.add(news);
			}
		} catch (SQLException e) {
			logger.error("Can't get news by author id" + e.getMessage(), e);
			throw new DaoException("Can't get news by author id"
					+ e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return newsList;
	}

	/**
	 * Find all news by tag ids array
	 * 
	 * @param tagIds
	 * @return news list
	 * @throws DaoException
	 */
	@Override
	public List<News> findByTags(Long[] tagIds) throws DaoException {
		List<News> newsList = new ArrayList<News>();
		String sql = SQL_SELECT_NEWS_BY_TAGS_QUERY
				+ DatabaseUtil.buildQueryPart(tagIds);
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getLong("news_id"));
				news.setShortText(rs.getString("short_text"));
				news.setFullText(rs.getString("full_text"));
				news.setTitle(rs.getString("title"));
				news.setCreationDate(new java.util.Date(rs.getTimestamp(
						"creation_date").getTime()));
				news.setModificationDate(new java.util.Date(rs.getDate(
						"creation_date").getTime()));
				newsList.add(news);
			}
		} catch (SQLException e) {
			logger.error("Can't get news by tag id" + e.getMessage(), e);
			throw new DaoException("Can't get news by tag id" + e.getMessage(),
					e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return newsList;
	}

	/**
	 * Get all news count
	 * 
	 * @return count
	 * @throws DaoException
	 */
	@Override
	public Long getCount() throws DaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		Long newsCount = 0L;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_SELECT_NEWS_COUNT_QUERY);
			while (rs.next()) {
				newsCount = rs.getLong("count(*)");
			}
		} catch (SQLException e) {
			logger.error("Can't get news count" + e.getMessage(), e);
			throw new DaoException("Can't get news count " + e.getMessage() + e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return newsCount;
	}

}