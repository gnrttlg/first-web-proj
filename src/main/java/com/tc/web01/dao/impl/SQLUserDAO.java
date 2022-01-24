package com.tc.web01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tc.web01.connectionPool.ConnectionPool;
import com.tc.web01.connectionPool.ConnectionPoolException;
import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.dao.UserDAO;
import com.tc.web01.dao.exception.DAOException;

public class SQLUserDAO implements UserDAO{

	@Override
	public String authorization(String login, String password) throws DAOException{

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			con = connectionPool.takeConnection();
			System.out.println("OK");

			st = con.createStatement();

			rs = st.executeQuery(
					"SELECT username, password, (SELECT name FROM roles where id = accounts.roles_id) FROM accounts WHERE username = '"
							+ login + "'");

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
			connectionPool.closeConnection(con, st);
		}
	}

	@Override
	public boolean registration(UserInfo newUser) throws DAOException{
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = connectionPool.takeConnection();
			System.out.println("OK");
			st = con.createStatement();
			rs = st.executeQuery("SELECT username FROM accounts WHERE username = '" + newUser.getLogin() + "'");
			if (rs.next()) {
				throw new DAOException("This username already registered");
			}
			String sql = "INSERT INTO accounts(first_name, last_name, username, password, address, roles_id) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, newUser.getName());
			ps.setString(2, newUser.getSurname());
			ps.setString(3, newUser.getLogin());
			ps.setString(4, newUser.getPassword());
			ps.setString(5, newUser.getAddress());
			ps.setInt(6, 2);
			ps.executeUpdate();
			return true;

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, st);
		}
	}



}
