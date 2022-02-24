package com.tc.web01.dao;

import java.util.List;

import com.tc.web01.controller.entity.Storage;
import com.tc.web01.dao.exception.DAOException;

public interface StorageDAO {

	List<Storage> getAllStorages() throws DAOException;
}
