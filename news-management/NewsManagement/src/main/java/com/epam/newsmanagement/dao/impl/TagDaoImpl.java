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

import com.epam.newsmanagement.dao.ITagDao;
import com.epam.newsmanagement.dao.util.DatabaseUtil;
import com.epam.newsmanagement.entity.Tag;
import com.epam.newsmanagement.exception.DaoException;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Tag dao implementation. Works with oracle database
 *         </p>
 */
public class TagDaoImpl implements ITagDao {

	private static final Logger logger = Logger.getLogger(TagDaoImpl.class);
	private DataSource dataSource;

	private static final String SQL_DELETE_TAG_QUERY = "DELETE FROM Tag WHERE tag_id";
	private static final String SQL_UPDATE_TAG_QUERY = "UPDATE Tag SET tag_name = ? WHERE tag_id= ?";
	private static final String SQL_INSERT_TAG_QUERY = "INSERT INTO Tag (tag_id, tag_name) \n"
			+ " VALUES (tag_seq.nextval, ?)";
	private static final String SQL_SELECT_TAG_QUERY = "SELECT tag_id, tag_name FROM Tag";
	private static final String SQL_SELECT_ALL_NEWS_TAGS_QUERY = "SELECT Tag.tag_id, Tag.tag_name"
			+ " FROM Tag JOIN News_Tag ON  Tag.tag_id = News_Tag.tag_id WHERE news_id = ?";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Add tag object in database
	 * 
	 * @param tag
	 * @return new tag id
	 * @throws DaoException
	 */
	@Override
	public Long add(Tag tag) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Long tagId = 0L;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_INSERT_TAG_QUERY,
					new String[] { "tag_id" });
			statement.setString(1, tag.getName());
			int affectedRows = statement.executeUpdate();
			if (affectedRows > 0) {
				rs = statement.getGeneratedKeys();
				if (null != rs && rs.next()) {
					tagId = rs.getLong(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Can't add tag" + e.getMessage(), e);
			throw new DaoException("Can't add tag" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		tag.setId(tagId);
		return tagId;
	}

	/**
	 * Load all tags from database
	 * 
	 * @return List of tags
	 * @throws DaoException
	 */
	@Override
	public List<Tag> loadAll() throws DaoException {
		List<Tag> tags = new ArrayList<Tag>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_SELECT_TAG_QUERY);
			while (rs.next()) {
				Tag tag = new Tag();
				tag.setId(rs.getLong("tag_id"));
				tag.setName(rs.getString("tag_name"));
				tags.add(tag);
			}
		} catch (SQLException e) {
			logger.error("Can't load all tags" + e.getMessage(), e);
			throw new DaoException("Can't load all tags" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return tags;
	}

	/**
	 * Load tag from database by id
	 * 
	 * @param tagId
	 * @return tag object
	 * @throws DaoException
	 */
	@Override
	public Tag load(Long tagId) throws DaoException {
		Tag tag = new Tag();
		String sql = SQL_SELECT_TAG_QUERY + " WHERE tag_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, tagId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Tag loadTag = new Tag();
				loadTag.setId(rs.getLong("tag_id"));
				loadTag.setName(rs.getString("tag_name"));
				tag = loadTag;
			}
		} catch (SQLException e) {
			logger.error("Can't load tag" + e.getMessage(), e);
			throw new DaoException("Can't load tag " + e.getMessage() + e, e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return tag;
	}

	/**
	 * Delete tags in database, that id in identifiers
	 * 
	 * @param tagIds
	 * @throws DaoException
	 */
	@Override
	public void delete(Long[] tagIds) throws DaoException {
		String sql = SQL_DELETE_TAG_QUERY
				+ DatabaseUtil.buildQueryPart(tagIds);
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			statement.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("Can't delete tag" + e.getMessage(), e);
			throw new DaoException("Can't delete tag " + e.getMessage() + e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * Update tag object in database
	 * 
	 * @param tag
	 * @throws DaoException
	 */
	@Override
	public void update(Tag tag) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(SQL_UPDATE_TAG_QUERY);
			statement.setString(1, tag.getName());
			statement.setLong(2, tag.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't update tag" + e.getMessage(), e);
			throw new DaoException("Can't update tag" + e.getMessage(), e);
		} finally {
			DatabaseUtil.close(statement, connection);
		}
	}

	/**
	 * Get all news tags by newsId
	 * 
	 * @param newsId
	 * @return list of tags
	 * @throws DaoException
	 */
	@Override
	public List<Tag> getAllNewsTags(Long newsId) throws DaoException {
		List<Tag> tags = new ArrayList<Tag>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection
					.prepareStatement(SQL_SELECT_ALL_NEWS_TAGS_QUERY);
			statement.setLong(1, newsId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Tag tag = new Tag();
				tag.setId(rs.getLong("tag_id"));
				tag.setName(rs.getString("tag_name"));
				tags.add(tag);
			}
		} catch (SQLException e) {
			logger.error("Can't get all news tags" + e.getMessage(), e);
			throw new DaoException("Can't get all news tags" + e.getMessage(),
					e);
		} finally {
			DatabaseUtil.close(rs, statement, connection);
		}
		return tags;
	}

}
