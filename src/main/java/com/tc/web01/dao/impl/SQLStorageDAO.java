package com.tc.web01.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tc.web01.connectionPool.ConnectionPool;
import com.tc.web01.connectionPool.ConnectionPoolException;
import com.tc.web01.controller.entity.Storage;
import com.tc.web01.dao.StorageDAO;
import com.tc.web01.dao.exception.DAOException;

public class SQLStorageDAO implements StorageDAO {

	private static final String selectAllStorages = "SELECT * FROM storages";

	@Override
	public List<Storage> getAllStorages() throws DAOException {
		List<Storage> storages = new ArrayList<Storage>();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = connectionPool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(selectAllStorages);
			while (rs.next()) {
				storages.add(new Storage(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return storages;
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, st);
		}
	}

}
