package com.tc.web01.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;
import com.tc.web01.service.ServiceFactory;
import com.tc.web01.service.StorageService;
import com.tc.web01.service.exception.ServiceException;

public class GoToStoragesPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ServiceFactory factory = ServiceFactory.getInstance();
		StorageService storageService = factory.getStorageService();
		try {
			session.setAttribute("storages", storageService.getAllStorages());
			session.setAttribute("url", "MyController?command=GO_TO_STORAGES_PAGE");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/storages.jsp");
			dispatcher.forward(request, response);

		} catch (ServiceException e) {
			session.setAttribute("errorMessage", e.getCause().getMessage());
			response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
		}

	}

}
