package com.tc.web01.service.impl;



import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.dao.DAOFactory;
import com.tc.web01.dao.UserDAO;
import com.tc.web01.dao.exception.DAOException;
import com.tc.web01.service.UserService;
import com.tc.web01.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public String authorization(String login, String password) throws ServiceException {

		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();

		String role;

		try {
			role = userDAO.authorization(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return role;
	}

	@Override
	public boolean registration(UserInfo newUser) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();

		Boolean success;

		try {
			success = userDAO.registration(newUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return success;
	}

}
