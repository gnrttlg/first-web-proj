package com.tc.web01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.tc.web01.connectionPool.ConnectionPool;
import com.tc.web01.connectionPool.ConnectionPoolException;
import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.dao.UserDAO;
import com.tc.web01.dao.exception.DAOException;
import java.util.ArrayList;

public class SQLUserDAO implements UserDAO {
	private static final String selectUserInfo = "SELECT username, password, (SELECT name FROM roles "
			+ "where id = accounts.roles_id) FROM accounts WHERE username = ?";
	private static final String insertUser = "INSERT INTO accounts(first_name, last_name, username, "
			+ "password, address, roles_id) VALUES(?,?,?,?,?,?)";
	private static final String selectUsername = "SELECT username FROM accounts WHERE username = ?";
	private static final String selectAllUser = "SELECT * FROM accounts";
	private static final String deleteById = "DELETE FROM accounts WHERE id = ?";

	@Override
	public String authorization(String login, String password) throws DAOException {

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = connectionPool.takeConnection();
			ps = con.prepareStatement(selectUserInfo);
			ps.setString(1, login);
			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString(3));
				if (!rs.getString(2).equals(password)) {
					throw new DAOException("Wrong password");
				}
				return rs.getString(3);
			}
			throw new DAOException("Wrong username");

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, ps);
		}
	}

	@Override
	public boolean registration(UserInfo newUser, String password) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement psSelect = null;
		PreparedStatement psInsert = null;
		ResultSet rs = null;
		try {
			con = connectionPool.takeConnection();
			psSelect = con.prepareStatement(selectUsername);
			psSelect.setString(1, newUser.getLogin());
			rs = psSelect.executeQuery();
			if (rs.next()) {
				throw new DAOException("This username already registered");
			}
			
			psInsert = con.prepareStatement(insertUser);
			psInsert.setString(1, newUser.getName());
			psInsert.setString(2, newUser.getSurname());
			psInsert.setString(3, newUser.getLogin());
			psInsert.setString(4, password);
			psInsert.setString(5, newUser.getAddress());
			psInsert.setInt(6, 2);
			psInsert.executeUpdate();
			return true;

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, psSelect);
			connectionPool.closeConnection(con, psInsert);
		}
	}

	@Override
	public List<UserInfo> getAllUsers() throws DAOException {
		List<UserInfo> users = new ArrayList<UserInfo>();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = connectionPool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(selectAllUser);
			while (rs.next()) {
				users.add(
						new UserInfo(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6)));
			}
			return users;
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, st);
		}
	}

	public int delete(int id) throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = connectionPool.takeConnection();
			ps = con.prepareStatement(deleteById);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, ps);
		}
	}

}
