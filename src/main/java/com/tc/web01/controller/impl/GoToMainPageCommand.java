package com.tc.web01.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;
import com.tc.web01.controller.entity.Good;
import com.tc.web01.service.GoodService;
import com.tc.web01.service.ServiceFactory;
import com.tc.web01.service.exception.ServiceException;

public class GoToMainPageCommand implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ServiceFactory factory = ServiceFactory.getInstance();
		GoodService goodService = factory.getGoodService();
		List<Good> cart;
		if(session.getAttribute("cart")==null) {
			cart = new ArrayList<Good>();
			session.setAttribute("cart", cart);
		}
		else
			cart = (List<Good>) session.getAttribute("cart");
		try {
			List<Good> goods = goodService.getAllGoods();
			for (Good good : cart) {
				for (Good good2 : goods) {
					if(good.getId()==good2.getId())
						good2.setInCart(true);
				}
			}
			session.setAttribute("goods", goods);
			session.setAttribute("url", "MyController?command=GO_TO_MAIN_PAGE");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
			dispatcher.forward(request, response);

		} catch (ServiceException e) {
			session.setAttribute("errorMessage", e.getCause().getMessage());
			response.sendRedirect("MyController?command=GO_TO_HELLO_PAGE");
		}
	}

}
