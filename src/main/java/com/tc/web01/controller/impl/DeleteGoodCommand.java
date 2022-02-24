package com.tc.web01.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tc.web01.controller.Command;
import com.tc.web01.service.GoodService;
import com.tc.web01.service.ServiceFactory;
import com.tc.web01.service.exception.ServiceException;

public class DeleteGoodCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Deleting good");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(true);
		ServiceFactory factory = ServiceFactory.getInstance();
		GoodService goodService = factory.getGoodService();
		try {
			goodService.delete(id);
		} catch (ServiceException e) {
			session.setAttribute("errorMessage", e.getCause().getMessage());
		} finally {
			response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
		}
	}

}
