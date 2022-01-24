package com.tc.web01.dao;

import com.tc.web01.dao.impl.SQLUserDAO;

public class DAOFactory {
	  private static final DAOFactory instance = new DAOFactory();

	    private final UserDAO userDAO = new SQLUserDAO();

	    public DAOFactory() {
	    }

	    public static DAOFactory getInstance() {
	        return instance;
	    }

	    public UserDAO getUserDAO() {
	        return userDAO;
	    }
}
