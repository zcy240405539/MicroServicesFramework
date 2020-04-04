package com.framework.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;
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

public class ProductAction extends ActionSupport{
	public String pid;
	public String pname;
	public String price;
	public String category;
	public String picture;	
	public String detail;
	public String[] pids;
	public String[] pnames;
	public String[] prices;
	public String[] categories;
	public String[] pictures;	
	public String[] details;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String checkProduct() {
		try {
			RestTemplate getTest = new RestTemplate();

			String beanResultName = getTest.getForObject("http://localhost:22222/checkProductName/"+pid, String.class);
			String beanResultPrice = getTest.getForObject("http://localhost:22222/checkProductPrice/"+pid, String.class);
			String beanResultCategory = getTest.getForObject("http://localhost:22222/checkProductCategory/"+pid, String.class);
			String beanPicture = getTest.getForObject("http://localhost:22222/checkProductPicture/"+pid, String.class);
			String beanResultDetail= getTest.getForObject("http://localhost:22222/checkProductDetail/"+pid, String.class);

			pname=beanResultName;
			price=beanResultPrice;
			category=beanResultCategory;
			picture=beanPicture;	
			detail=beanResultDetail;
		}catch(Exception e) {
			   e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String checkCategory() {
		try {
			RestTemplate getTest = new RestTemplate();
			String beanResult=getTest.getForObject("http://localhost:22222/checkCategory/"+category, String.class);
			pids=beanResult.split("\\|");
			pnames=new String[pids.length];
			prices=new String[pids.length];
			categories=new String[pids.length];
			pictures=new String[pids.length];
			details=new String[pids.length];
			
			for(int i=0; i<pids.length;i++) {
				pnames[i]= getTest.getForObject("http://localhost:22222/checkProductName/"+pids[i], String.class);
				prices[i] = getTest.getForObject("http://localhost:22222/checkProductPrice/"+pids[i], String.class);
				categories[i] = getTest.getForObject("http://localhost:22222/checkProductCategory/"+pids[i], String.class);
				pictures[i] = getTest.getForObject("http://localhost:22222/checkProductPicture/"+pids[i], String.class);
				details[i]= getTest.getForObject("http://localhost:22222/checkProductDetail/"+pids[i], String.class);
				/*
				System.out.println(pids[i]);
				System.out.println(pnames[i]);
				System.out.println(prices[i]);
				System.out.println(categories[i]);
				System.out.println(pictures[i]);
				System.out.println(details[i]);
				*/
			}		
			
		}catch(Exception e) {
			   e.printStackTrace();
		}
		if(category=="Phone") {
			return "Phone";
	
		}else if(category=="Accessories") {
			return "Accessories";
		}else {
			return "error";
		}
		//return SUCCESS;
	}
	
}
