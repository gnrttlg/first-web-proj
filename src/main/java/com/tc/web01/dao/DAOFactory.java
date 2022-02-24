package com.tc.web01.dao;

import com.tc.web01.dao.impl.SQLGoodDAO;
import com.tc.web01.dao.impl.SQLStorageDAO;
import com.tc.web01.dao.impl.SQLUserDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final UserDAO userDAO = new SQLUserDAO();
	private final GoodDAO goodDAO = new SQLGoodDAO();
	private final StorageDAO storageDAO = new SQLStorageDAO();
	
	public DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public GoodDAO getGoodDAO() {
		return goodDAO;
	}

	public StorageDAO getStorageDAO() {
		return storageDAO;
	}
	
	
}
