package com.framework.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.framework.business.CustomerSession;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, CookiesAware {
	
	@Autowired
	CustomerSession session;
	private HttpServletResponse response;
	private HttpServletRequest request;
	Map<String, String> cookiesMap;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getResponse() {
		return response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public Map<String, String> getCookiesMap() {
		return cookiesMap;
	}
	//@Override
	public void setCookiesMap(Map<String, String> cookiesMap) {
		this.cookiesMap = cookiesMap;
	}
	
	public String HomepageAction() {
		session.isCustomerLoggedin=false;
		Cookie[] cookies = request.getCookies();
		try {
			for(Cookie cookie:cookies) {
				System.out.println(cookie.getName()+": "+cookie.getValue());
				if(cookie.getName().equals("userid")) {
					session.isCustomerLoggedin=true;
					request.getSession().setAttribute("loggedin", true);
					request.getSession().setAttribute("userid", cookie.getValue());
				}
			}
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
				
	}
	
}
