package com.tc.web01.service;

import java.util.List;

import com.tc.web01.controller.entity.Storage;
import com.tc.web01.service.exception.ServiceException;

public interface StorageService {
	List<Storage> getAllStorages() throws ServiceException;
}
