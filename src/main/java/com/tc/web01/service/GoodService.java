package com.tc.web01.service;

import java.util.List;

import com.tc.web01.controller.entity.Good;
import com.tc.web01.service.exception.ServiceException;

public interface GoodService {
	List<Good> getAllGoods() throws ServiceException;
}
