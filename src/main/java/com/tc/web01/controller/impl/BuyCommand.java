package com.tc.web01.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;
import com.tc.web01.controller.entity.Good;
import com.tc.web01.service.GoodService;
import com.tc.web01.service.ServiceFactory;
import com.tc.web01.service.exception.ServiceException;

public class BuyCommand implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Buying good");
		HttpSession session = request.getSession(true);
		ServiceFactory factory = ServiceFactory.getInstance();
		GoodService goodService = factory.getGoodService();
		List<Good> cart = (List<Good>) session.getAttribute("cart");
		try {
			for (Good good : cart) {
				goodService.delete(good.getId());
			}
			session.setAttribute("cart", new ArrayList<Good>());
		} catch (ServiceException e) {
			session.setAttribute("errorMessage", e.getCause().getMessage());
		} finally {
			response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
		}

	}

}
