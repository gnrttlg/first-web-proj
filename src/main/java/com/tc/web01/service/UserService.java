package com.tc.web01.service;

import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.service.exception.ServiceException;

public interface UserService {
	String authorization(String login, String password) throws ServiceException;
	boolean registration(UserInfo newUser) throws ServiceException;
}
