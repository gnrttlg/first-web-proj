package com.tc.web01.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tc.web01.controller.entity.Good;
import com.tc.web01.dao.DAOFactory;
import com.tc.web01.dao.GoodDAO;
import com.tc.web01.dao.exception.DAOException;
import com.tc.web01.service.GoodService;
import com.tc.web01.service.exception.ServiceException;

public class GoodServiceImpl implements GoodService {

	@Override
	public List<Good> getAllGoods() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		GoodDAO goodDAO = daoFactory.getGoodDAO();

		List<Good> goods = new ArrayList<Good>();

		try {
			goods = goodDAO.getAllGoods();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return goods;
	}

}
