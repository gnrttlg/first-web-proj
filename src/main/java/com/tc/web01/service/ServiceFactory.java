package com.tc.web01.service;

import com.tc.web01.service.impl.GoodServiceImpl;
import com.tc.web01.service.impl.StorageServiceImpl;
import com.tc.web01.service.impl.UserServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final UserService userService = new UserServiceImpl();
	private final GoodService goodService = new GoodServiceImpl();
	private final StorageService storageService = new StorageServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public GoodService getGoodService() {
		return goodService;
	}

	public StorageService getStorageService() {
		return storageService;
	}
}
