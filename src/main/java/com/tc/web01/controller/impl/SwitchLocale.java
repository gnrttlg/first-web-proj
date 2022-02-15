package com.tc.web01.controller.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tc.web01.controller.Command;

public class SwitchLocale implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).setAttribute("local", request.getParameter("local"));
		String url = (String) request.getSession().getAttribute("url");
		System.out.println(url);
		response.sendRedirect(url);
	}

}