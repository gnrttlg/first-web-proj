package com.tc.web01.controller.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;
import com.tc.web01.controller.entity.Greeting;
import com.tc.web01.service.ServiceFactory;
import com.tc.web01.service.UserService;
import com.tc.web01.service.exception.ServiceException;

public class AuthorizationCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Authorization");
		String name;
		String psw;
		boolean remember;
		name = request.getParameter("name");
		psw = request.getParameter("psw");
		remember = "on".equals(request.getParameter("remember"));
		Greeting greeting = new Greeting("Hello again ");

		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		String role;
		HttpSession session = request.getSession(true);
		try {
			role = userService.authorization(name, psw);
			session.setAttribute("userName", name);
			session.setAttribute("role", role);
			session.setAttribute("remember", remember);
			session.setAttribute("greeting", greeting);
			response.sendRedirect("MyController?command=GO_TO_MAIN_PAGE");
		} catch (ServiceException e) {
			session.setAttribute("errorMessage", e.getMessage());
			response.sendRedirect("MyController?command=GO_TO_AUTHORIZATION_PAGE");
		}

	}

}
