package com.tc.web01.dao;

import java.util.List;

import com.tc.web01.controller.entity.Good;
import com.tc.web01.dao.exception.DAOException;

public interface GoodDAO {
	List<Good> getAllGoods() throws DAOException;
	public int delete(int id) throws DAOException;
}
