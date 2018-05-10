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

import com.epam.newsmanagement.dao.IAuthorDao;
import com.epam.newsmanagement.dao.util.DatabaseUtil;
import com.epam.newsmanagement.entity.Author;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Author dao implementation. Works with oracle database
 *         </p>
 */
public class AuthorDaoImpl implements IAuthorDao {

	private static final Logger logger = Logger.getLogger(AuthorDaoImpl.class);
	private DataSource dataSource;

	private static final String SQL_DELETE_AUTHOR_QUERY = "DELETE FROM Author WHERE author_id";
	private static final String SQL_UPDATE_AUTHOR_QUERY = "UPDATE Author SET name=?, expired=? WHERE author_id= ?";
	private static final String SQL_INSERT_AUTHOR_QUERY = "INSERT INTO Author (author_id, name, expired) "
			+ "VALUES (author_seq.nextval, ?, ?)";
	private static final String SQL_SELECT_AUTHOR_QUERY = "SELECT author_id, name, expired FROM Author";
	private static final String SQL_SELECT_AUTHOR_BY_NEWS_ID_QUERY = "SELECT Author.author_id, Author.name,"
			+ " Author.expired FROM Author JOIN News_Author"
			+ " ON  Author.author_id = News_Author.author_id WHERE news_id = ?";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Add author object in database
	 * 
	 * @param author
	 * @return new author id
	 * @throws DaoException
	 */
	@Override
	public Long add(Author author) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Long authorId = 0L;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_INSERT_AUTHOR_QUERY,
					new String[] { "author_id" });
			statement.setString(1, author.getName());
			statement.setTimestamp(2, new java.sql.Timestamp(author
					.getExpired().getTime()));
			int affectedRows = statement.executeUpdate();
			if (affectedRows > 0) {
				rs = statement.getGeneratedKeys();
				if (null != rs && rs.next()) {
					authorId = rs.getLong(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Can't add author " + e.getMessage(), e);
			throw new DaoException("Can't add author " + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		author.setId(authorId);
		return authorId;
	}

	/**
	 * Load all authors from database
	 * 
	 * @return List of authors
	 * @throws DaoException
	 */
	@Override
	public List<Author> loadAll() throws DaoException {
		List<Author> authors = new ArrayList<Author>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_SELECT_AUTHOR_QUERY);
			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getLong("author_id"));
				author.setName(rs.getString("name"));
				author.setExpired(new java.util.Date(rs.getTimestamp("expired")
						.getTime()));
				authors.add(author);
			}
		} catch (SQLException e) {
			logger.error("Can't load all authors" + e.getMessage(), e);
			throw new DaoException("Can't load all authors" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return authors;
	}

	/**
	 * Load author from database by id
	 * 
	 * @param authorId
	 * @return author
	 * @throws DaoException
	 */
	@Override
	public Author load(Long authorId) throws DaoException {
		Author author = new Author();
		String sql = SQL_SELECT_AUTHOR_QUERY + " WHERE author_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, authorId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Author loadAuthor = new Author();
				loadAuthor.setId(rs.getLong("author_id"));
				loadAuthor.setName(rs.getString("name"));
				loadAuthor.setExpired(new java.util.Date(rs.getTimestamp(
						"expired").getTime()));
				author = loadAuthor;
			}
		} catch (SQLException e) {
			logger.error("Can't load author" + e.getMessage(), e);
			throw new DaoException("Can't load author " + e.getMessage() + e, e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return author;
	}

	/**
	 * Delete authors in database, that id in identifiers
	 * 
	 * @param authorIds
	 * @throws DaoException
	 */
	@Override
	public void delete(Long[] authorIds) throws DaoException {
		String sql = SQL_DELETE_AUTHOR_QUERY
				+ DatabaseUtil.buildQueryPart(authorIds);
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			statement.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("Can't delete author" + e.getMessage(), e);
			throw new DaoException("Can't delete author " + e.getMessage() + e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * Update author object in database
	 * 
	 * @param author
	 * @throws DaoException
	 */
	@Override
	public void update(Author author) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_UPDATE_AUTHOR_QUERY);
			statement.setString(1, author.getName());
			statement.setTimestamp(2, new java.sql.Timestamp(author
					.getExpired().getTime()));
			statement.setLong(3, author.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't update author" + e.getMessage(), e);
			throw new DaoException("Can't update author" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * 
	 * Get news author by newsId
	 * 
	 * @param newsId
	 * @return author entity
	 * @throws DaoException
	 */

	@Override
	public Author getByNewsId(Long newsId) throws DaoException {
		Author author = new Author();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection
					.prepareStatement(SQL_SELECT_AUTHOR_BY_NEWS_ID_QUERY);
			statement.setLong(1, newsId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Author loadAuthor = new Author();
				loadAuthor.setId(rs.getLong("author_id"));
				loadAuthor.setName(rs.getString("name"));
				loadAuthor.setExpired(new java.util.Date(rs.getTimestamp(
						"expired").getTime()));
				author = loadAuthor;
			}
		} catch (SQLException e) {
			logger.error("Can't get author by news id" + e.getMessage(), e);
			throw new DaoException("Can't get author by news id"
					+ e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return author;
	}

}
