package com.tc.web01.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {
	
	private String encoding;
	
	public void init(FilterConfig config) throws ServletException
	{
		encoding = config.getInitParameter("requestEncoding");
		if(encoding==null) encoding="utf-8";
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);
		chain.doFilter(request,response);
	}
	public void destroy() {}
}
