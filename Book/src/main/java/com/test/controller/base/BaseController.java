package com.test.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
	private HttpServletRequest hreq;
	private HttpServletResponse hresp;
	private HttpSession session;
	public HttpServletRequest getHreq() {
		return hreq;
	}
	public void setHreq(HttpServletRequest hreq) {
		this.hreq = hreq;
	}
	public HttpServletResponse getHresp() {
		return hresp;
	}
	public void setHresp(HttpServletResponse hresp) {
		this.hresp = hresp;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
}
