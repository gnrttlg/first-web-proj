package com.tc.web01.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tc.web01.connectionPool.ConnectionPool;
import com.tc.web01.connectionPool.ConnectionPoolException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ConnectionPool.getInstance();
		super.init(config);
	}

	@Override
	public void destroy() {
		try {
			ConnectionPool.getInstance().dispose();
		} catch (ConnectionPoolException e) {
			throw new RuntimeException("ConnectionPoolException", e);
		}
		super.destroy();
	}

	private final CommandProvider provider = new CommandProvider();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String commandName = request.getParameter("command");
		Command command = provider.getCommand(commandName);
		command.execute(request, response);
	}

}
