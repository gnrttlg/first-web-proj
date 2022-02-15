package com.tc.web01.dao;

import java.util.List;

import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.dao.exception.DAOException;

public interface UserDAO {
	String authorization(String login, String password) throws DAOException;

	boolean registration(UserInfo newUser, String password) throws DAOException;

	List<UserInfo> getAllUsers() throws DAOException;

	public int delete(int id) throws DAOException;
}
