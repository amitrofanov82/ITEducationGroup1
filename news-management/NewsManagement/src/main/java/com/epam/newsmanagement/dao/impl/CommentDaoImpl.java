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

import com.epam.newsmanagement.dao.ICommentDao;
import com.epam.newsmanagement.dao.util.DatabaseUtil;
import com.epam.newsmanagement.entity.Comment;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Comment dao implementation. Works with oracle database
 *         </p>
 */
public class CommentDaoImpl implements ICommentDao {

	private static final Logger logger = Logger.getLogger(CommentDaoImpl.class);
	private DataSource dataSource;

	private static final String SQL_DELETE_COMMENT_QUERY = "DELETE FROM Comments WHERE comment_id";
	private static final String SQL_UPDATE_COMMENT_QUERY = "UPDATE Comments SET comment_text = ?,"
			+ " creation_date = ?, news_id = ? WHERE comment_id= ?";
	private static final String SQL_INSERT_COMMENT_QUERY = "INSERT INTO Comments "
			+ "(comment_id, comment_text, creation_date, news_id) "
			+ "VALUES (comments_seq.nextval, ?, ?, ?)";
	private static final String SQL_SELECT_COMMENT_QUERY = "SELECT comment_id, comment_text, creation_date,"
			+ " news_id FROM Comments";
	private static final String SQL_GET_ALL_NEWS_COMMENTS_QUERY = "SELECT Comments.comment_id,"
			+ " Comments.comment_text, Comments.creation_date, Comments.news_id FROM Comments JOIN News"
			+ " ON  Comments.news_id = News.news_id WHERE News.news_id = ?";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Add comment object in database
	 * 
	 * @param comment
	 * @return new comment id
	 * @throws DaoException
	 */
	@Override
	public Long add(Comment comment) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Long commentId = 0L;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_INSERT_COMMENT_QUERY,
					new String[] { "comment_id" });
			statement.setString(1, comment.getCommentText());
			statement.setTimestamp(2, new java.sql.Timestamp(comment
					.getCreationDate().getTime()));
			statement.setLong(3, comment.getNewsId());
			int affectedRows = statement.executeUpdate();
			if (affectedRows > 0) {
				rs = statement.getGeneratedKeys();
				if (null != rs && rs.next()) {
					commentId = rs.getLong(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Can't add comment" + e.getMessage(), e);
			throw new DaoException("Can't add comment" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		comment.setId(commentId);
		return commentId;
	}

	/**
	 * Load all comments from database
	 * 
	 * @return List of comments
	 * @throws DaoException
	 */
	@Override
	public List<Comment> loadAll() throws DaoException {
		List<Comment> comments = new ArrayList<Comment>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_SELECT_COMMENT_QUERY);
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getLong("comment_id"));
				comment.setCommentText(rs.getString("comment_text"));
				comment.setCreationDate(new java.util.Date(rs.getDate(
						"creation_date").getTime()));
				comment.setNewsId(rs.getLong("news_id"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			logger.error("Can't load all comments" + e.getMessage(), e);
			throw new DaoException("Can't load all comments" + e.getMessage(),
					e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return comments;
	}

	/**
	 * Load comment from database by id
	 * 
	 * @param commentId
	 * @return comment
	 * @throws DaoException
	 */
	@Override
	public Comment load(Long commentId) throws DaoException {
		Comment comment = new Comment();
		String sql = SQL_SELECT_COMMENT_QUERY + " WHERE comment_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, commentId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Comment loadComment = new Comment();
				loadComment.setId(rs.getLong("comment_id"));
				loadComment.setCommentText(rs.getString("comment_text"));
				loadComment.setCreationDate(new java.util.Date(rs.getDate(
						"creation_date").getTime()));
				loadComment.setNewsId(rs.getLong("news_id"));
				comment = loadComment;
			}
		} catch (SQLException e) {
			logger.error("Can't load comment" + e.getMessage(), e);
			throw new DaoException("Can't load comment " + e.getMessage() + e,
					e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return comment;
	}

	/**
	 * Delete comments in database, that id in identifiers
	 * 
	 * @param commentIds
	 * @throws DaoException
	 */
	@Override
	public void delete(Long[] commentIds) throws DaoException {
		String sql = SQL_DELETE_COMMENT_QUERY
				+ DatabaseUtil.buildQueryPart(commentIds);
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			statement.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("Can't delete comment" + e.getMessage(), e);
			throw new DaoException("Can't delete comment " + e.getMessage() + e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * Update comment object in database
	 * 
	 * @param comment
	 * @throws DaoException
	 */
	@Override
	public void update(Comment comment) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_UPDATE_COMMENT_QUERY);
			statement.setString(1, comment.getCommentText());
			statement.setTimestamp(2, new java.sql.Timestamp(comment
					.getCreationDate().getTime()));
			statement.setLong(3, comment.getNewsId());
			statement.setLong(4, comment.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't update comment" + e.getMessage(), e);
			throw new DaoException("Can't update comment" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * Get all news comments by newsId
	 * 
	 * @param newsId
	 * @return list of comments
	 * @throws DaoException
	 */
	@Override
	public List<Comment> getAllNewsComments(Long newsId) throws DaoException {
		List<Comment> comments = new ArrayList<Comment>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection
					.prepareStatement(SQL_GET_ALL_NEWS_COMMENTS_QUERY);
			statement.setLong(1, newsId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getLong("comment_id"));
				comment.setCommentText(rs.getString("comment_text"));
				comment.setCreationDate(new java.util.Date(rs.getDate(
						"creation_date").getTime()));
				comment.setNewsId(rs.getLong("news_id"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			logger.error("Can't get all news comments" + e.getMessage(), e);
			throw new DaoException("Can't get all news comments"
					+ e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return comments;
	}
}
