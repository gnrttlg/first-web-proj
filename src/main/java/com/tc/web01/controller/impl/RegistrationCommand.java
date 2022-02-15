package com.tc.web01.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;
import com.tc.web01.controller.entity.UserInfo;
import com.tc.web01.service.ServiceFactory;
import com.tc.web01.service.UserService;
import com.tc.web01.service.exception.ServiceException;

public class RegistrationCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Registration");
		String name;
		String surname;
		String login;
		String password;
		String address;
		name = request.getParameter("name");
		surname = request.getParameter("surname");
		login = request.getParameter("login");
		password = request.getParameter("psw");
		address = request.getParameter("address");
		HttpSession session = request.getSession(true);

		UserInfo userInfo = new UserInfo(name, surname, login, address);

		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		try {
			userService.registration(userInfo, password);
			session.setAttribute("userName", name);
			session.setAttribute("role", "user");
			response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");

		} catch (ServiceException e) {
			session.setAttribute("errorMessage", e.getCause().getMessage());
			response.sendRedirect("MyController?command=GO_TO_REGISTRATION_PAGE");
		}

	}

}
