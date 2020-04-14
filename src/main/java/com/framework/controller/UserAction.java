package com.framework.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Map;

import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

//import com.framework.business.UserBean;
import com.opensymphony.xwork2.ActionSupport;
import com.framework.business.CustomerSession;

public class UserAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, CookiesAware {
	private static final long serialVersionUID = 1L;
	// HTML source form beans
	public String userid;
	public String pwd;
	public String currentpwd;
	public String firstname;
	public String lastname;
	public String address;
	public boolean checked;
	public boolean isUserLoggedin=false;
	private HttpServletResponse response;
	private HttpServletRequest request;
	// For handling cookies
	Map<String, String> cookiesMap;
	
	@Autowired
	CustomerSession session;

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	//public void setRequest(HttpServletRequest request) {
	//	this.request = request;
	//}
	
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
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isUserLoggedin() {
		return isUserLoggedin;
	}
	public void setUserLoggedin(boolean isUserLoggedin) {
		this.isUserLoggedin = isUserLoggedin;
	}

	public String DelUserCookie() {
		//System.out.println("start delete cookies");
		session.isCustomerLoggedin=false;
		session.currentUser=null;
		request.getSession().setAttribute("loggedin", false);
		request.getSession().setAttribute("userid", null);
		
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
			
			this.isUserLoggedin = true;
			session.isCustomerLoggedin=isUserLoggedin;
			session.currentUser=currentUserid;
			request.getSession().setAttribute("loggedin", isUserLoggedin);
			request.getSession().setAttribute("userid", currentUserid);
			request.getSession().setMaxInactiveInterval(60*10);
			
			//System.out.println("user remember: "+checked);
			if(this.checked==true) {
				Cookie useridCookie = new Cookie("userid", currentUserid);
				useridCookie.setMaxAge(60 * 60 * 24);
				useridCookie.setPath("/");
				response.addCookie(useridCookie);
			}

		}
		
		return beanResult;
	}

	public String UserSession() {
		try {
			this.isUserLoggedin = session.isCustomerLoggedin;
			response = null;
			request = null;
		
			if(isUserLoggedin==true) {
				this.userid = session.currentUser;
				return SUCCESS;
			}else {
				return ERROR;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String Register() {
		//String beanResult = userBean.Register(userid, pwd, username, address);
		if(firstname.equals(null)||firstname.equals(""))
			firstname="null";
		if(lastname.equals(null)||lastname.equals(""))
			lastname="null";
		if(address.equals(null)||address.equals(""))
			address="null";
		RestTemplate getTest = new RestTemplate();
		String beanResult = getTest.getForObject("http://localhost:11111/registRest/"+userid+"/"+pwd+"/"+firstname+"/"+lastname+"/"+address, String.class);
		// registerStatus = beanResult;
		return beanResult;
	}

	public String Destroy() {
		String currentUserid = session.currentUser;
		RestTemplate getTest = new RestTemplate();
		String password = getTest.getForObject("http://localhost:11111/checkpwd/"+currentUserid, String.class);
		String beanResult = getTest.getForObject("http://localhost:11111/destroyRest/"+currentUserid+"/"+password, String.class);
		DelUserCookie();

		return beanResult;
	}

	public String Update() {
		String currentUserid = session.currentUser;
		RestTemplate getTest = new RestTemplate();
		String password = getTest.getForObject("http://localhost:11111/checkpwd/"+currentUserid, String.class);
		//System.out.println("curren user: "+currentUserid);
		//System.out.println("getpassword: "+password);
		//System.out.println("currentpassword: "+currentpwd);
		String beanResult = "error";
		if(password.equals(currentpwd)) {
			beanResult = getTest.getForObject("http://localhost:11111/updateRest/"+currentUserid+"/"+pwd+"/"+firstname+"/"+lastname+"/"+address, String.class);
			//System.out.println("result: "+beanResult);
		}
		return beanResult;
	}

	public String getCookieValue(String str) {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		String result = null;
		for (Cookie cookie : cookies) {
			//System.out.println("cookie: "+cookie.getName()+"="+cookie.getValue());
			if (cookie.getName().equals(str)) {
				result = cookie.getValue();
				break;
			}
		}
		return result;
	}
	
	public String doesUserExist() {
		String beanResult = "error";
		try {
			RestTemplate getTest = new RestTemplate();
			beanResult = getTest.getForObject("http://localhost:11111/checkuser/"+userid, String.class);
			
			checked = true;
			response = null;
			request = null;
		
			return beanResult;
		
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
	}

}
