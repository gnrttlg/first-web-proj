package com.tc.web01.dao;

import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.dao.exception.DAOException;

public interface UserDAO {
    String authorization(String login, String password) throws DAOException;

    boolean registration(UserInfo newUser) throws DAOException;
}
