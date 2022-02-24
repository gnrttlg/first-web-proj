package com.tc.web01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tc.web01.connectionPool.ConnectionPool;
import com.tc.web01.connectionPool.ConnectionPoolException;
import com.tc.web01.controller.entity.Good;
import com.tc.web01.dao.GoodDAO;
import com.tc.web01.dao.exception.DAOException;

public class SQLGoodDAO implements GoodDAO {
	private static final String selectGood = "SELECT id, (SELECT title FROM storage_has_goods "
			+ "where id = goods.storage_has_goods_id), (SELECT price FROM storage_has_goods "
			+ "where id = goods.storage_has_goods_id), (SELECT storages_id FROM storage_has_goods "
			+ "where id = goods.storage_has_goods_id), (SELECT count FROM storage_has_goods "
			+ "where id = goods.storage_has_goods_id) FROM goods";
	

	private static final String deleteById = "DELETE FROM goods WHERE id = ?";
	
	
	@Override
	public List<Good> getAllGoods() throws DAOException {
		List<Good> goods = new ArrayList<Good>();
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = connectionPool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(selectGood);
			while (rs.next()) {
				goods.add(new Good(rs.getInt(1),rs.getString(2), rs.getFloat(3), "", rs.getInt(4), rs.getInt(5)));
			}
			return goods;
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
