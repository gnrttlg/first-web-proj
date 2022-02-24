package com.tc.web01.controller.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;
import com.tc.web01.controller.entity.Good;

public class RemoveFromCartCommand implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<Good> cart = (List<Good>) session.getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));
		for (Good good : cart) {
			if(good.getId()==id) {
				cart.remove(good);
				break;
			}
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("MyController?command=GO_TO_CART_PAGE");

	}

}
