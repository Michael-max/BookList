package com.test.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.controller.BookController;

public class BookFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hresp = (HttpServletResponse)response;
		HttpSession session = hreq.getSession();
		String uri = hreq.getRequestURI();
		String nameSpace = uri.split("/")[2];
		String method = uri.split("/")[3];
		
		if("book".equals(nameSpace)) {
			BookController book = new BookController();
			book.setHreq(hreq);
			book.setHresp(hresp);
			book.setSession(session);
			
			if("toList.do".equals(method)) {
				
			}else if("del.do".equals(method)) {
				
			}else if("toUpdate.do".equals(method)) {
				
			}else if("insertOrUpdate.do".equals(method)) {
				
			}
		}
		
	}

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

}
