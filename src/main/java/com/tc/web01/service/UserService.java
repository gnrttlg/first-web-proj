package com.tc.web01.service;

import java.util.List;

import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.service.exception.ServiceException;

public interface UserService {
	String authorization(String login, String password) throws ServiceException;

	boolean registration(UserInfo newUser, String password) throws ServiceException;

	List<UserInfo> getAllUsers() throws ServiceException;

	public void delete(int id) throws ServiceException;
}
