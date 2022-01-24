package com.tc.web01.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.web01.controller.Command;

public class GoToHelloPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=  request.getSession(true);
		session.setAttribute("Helloing","Sonochinosadame");
		session.setAttribute("url", "MyController?command=GO_TO_HELLO_PAGE");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/helloPage.jsp");
		dispatcher.forward(request, response);	
	}

}
