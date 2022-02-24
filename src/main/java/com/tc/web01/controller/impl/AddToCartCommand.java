package com.tc.web01.controller.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;
import com.tc.web01.controller.entity.Good;

public class AddToCartCommand implements Command {
	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<Good> cart = (List<Good>) session.getAttribute("cart");
		List<Good> goods = (List<Good>) session.getAttribute("goods");
		int id = Integer.parseInt(request.getParameter("id"));
		for (Good good : goods) {
			if(!good.isInCart()&&good.getId()==id) {
				good.setInCart(true);
				cart.add(good);
			}
		}
		session.setAttribute("goods", goods);
		session.setAttribute("cart", cart);
		response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
	}

}
