package com.framework.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

//import com.framework.business.UserBean;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletResponseAware, CookiesAware {
	private static final long serialVersionUID = 1L;
	// HTML source form beans
	public String userid;
	public String pwd;
	public String currentpwd;
	public String firstname;
	public String lastname;
	public String address;
	private HttpServletResponse response;
	private HttpServletRequest request;
	// For handling cookies
	Map<String, String> cookiesMap;

	//@Autowired
	//UserBean userBean;

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public Map<String, String> getCookiesMap() {
		return cookiesMap;
	}
	//@Override
	public void setCookiesMap(Map<String, String> cookiesMap) {
		this.cookiesMap = cookiesMap;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getCurrentpwd() {
		return currentpwd;
	}

	public void setCurrentpwd(String currentpwd) {
		this.currentpwd = currentpwd;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * public String registerStatus; public String getRegisterStatus() { return
	 * registerStatus; } public void setRegisterStatus(String registerStatus) {
	 * this.registerStatus = registerStatus; }
	 */
	
	public String DelUserCookie() {
		System.out.println("start delete cookies");
		
		Cookie useridCookie = new Cookie("userid", "");
		useridCookie.setMaxAge(0);
		useridCookie.setPath("/");
		response.addCookie(useridCookie);	
		
		/*
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				System.out.println("Cookie just cleaned "+cookie.getName()+": "+cookie.getValue());
			}
		}
		*/
		//request.getSession().setAttribute("login", false);
		//request.getSession().removeAttribute("userid");
		return "success";
	}

	public String Login() {
		RestTemplate getTest = new RestTemplate();
		//String beanResult = userBean.Auth(userid, pwd);
		String beanResult = getTest.getForObject("http://localhost:11111/authRest/"+userid+"/"+pwd, String.class);
		
		if(beanResult.equals("success")) {
			// set cookie
			String currentUserid = this.userid;

			
			Cookie useridCookie = new Cookie("userid", currentUserid);
			useridCookie.setMaxAge(60 * 60 * 24);
			useridCookie.setPath("/");
			response.addCookie(useridCookie);
			

			//request.getSession().setAttribute("login", true);
			//request.getSession().setAttribute("userid",currentUserid);
			//request.getSession().setMaxInactiveInterval(1800);
			

		}
		
		return beanResult;
	}

	public String Register() {
		//String beanResult = userBean.Register(userid, pwd, username, address);
		RestTemplate getTest = new RestTemplate();
		String beanResult = getTest.getForObject("http://localhost/registRest/"+userid+"/"+pwd+"/"+firstname+"/"+lastname+"/"+address, String.class);
		// registerStatus = beanResult;
		return beanResult;
	}

	public String Destroy() {
		String currentUserid = getCookieValue("userid");
		this.setUserid(currentUserid);
		//String beanResult = userBean.Destroy(userid, pwd);
		RestTemplate getTest = new RestTemplate();
		String beanResult = getTest.getForObject("http://localhost/destroyRest/"+userid+"/"+pwd, String.class);
		DelUserCookie();
		return beanResult;
	}

	public String Update() {
		//String currentUserid = cookiesMap.get("userid");
		String currentUserid = getCookieValue("userid");
		this.setUserid(currentUserid);
		//String beanResult = userBean.Update(userid,currentpwd,pwd,username,address);
		RestTemplate getTest = new RestTemplate();
		String beanResult = getTest.getForObject("http://localhost/updateRest/"+userid+"/"+pwd+"/"+firstname+"/"+lastname+"/"+address, String.class);
		return beanResult;
	}

	public String getCookieValue(String str) {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		String result = null;
		for (Cookie cookie : cookies) {
			System.out.println("cookie: "+cookie.getName()+"="+cookie.getValue());
			if (cookie.getName().equals(str)) {
				result = cookie.getValue();
				break;
			}
		}
		return result;
	}



}
