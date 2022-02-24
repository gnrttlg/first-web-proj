package com.tc.web01.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tc.web01.controller.entity.Storage;
import com.tc.web01.dao.DAOFactory;
import com.tc.web01.dao.StorageDAO;
import com.tc.web01.dao.exception.DAOException;
import com.tc.web01.service.StorageService;
import com.tc.web01.service.exception.ServiceException;

public class StorageServiceImpl implements StorageService {

	@Override
	public List<Storage> getAllStorages() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		StorageDAO storageDAO = daoFactory.getStorageDAO();

		List<Storage> storages = new ArrayList<Storage>();

		try {
			storages = storageDAO.getAllStorages();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return storages;
	}

}
