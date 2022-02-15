package com.tc.web01.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public boolean registration(UserInfo newUser, String password) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();

		Boolean success;

		try {
			success = userDAO.registration(newUser, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return success;
	}

	@Override
	public List<UserInfo> getAllUsers() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();

		List<UserInfo> users = new ArrayList<UserInfo>();

		try {
			users = userDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return users;
	}

	@Override
	public void delete(int id) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		try {
			userDAO.delete(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
