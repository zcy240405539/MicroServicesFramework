package com.framework.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.framework.business.CustomerSession;
import com.framework.jpa.*;

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
	List<ProductsEntityDTO> allProducts =new ArrayList<ProductsEntityDTO>();
	private HttpServletResponse response;
	private HttpServletRequest request;
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
	
	public List<ProductsEntityDTO> getAllProducts() {
		return allProducts;
	}
	public void setAllProducts(List<ProductsEntityDTO> allProducts) {
		this.allProducts = allProducts;
	}
	
	public String checkProduct() {
		try {
			RestTemplate getTest = new RestTemplate();
			ProductsEntityDTO product = getTest.getForObject("http://"+session.IP+":22222/checkProduct/"+pid, ProductsEntityDTO.class);

			pname=product.getPname();
			price=product.getPrice();
			category=product.getCategory();
			picture=product.getPicture();	
			detail=product.getDetail();	
			
			/*
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
			*/
			return "success";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		//return SUCCESS;
	}
	
	public String checkCategory() {
		try {
			RestTemplate getTest = new RestTemplate();
			ProductsEntityDTO[] products = getTest.getForObject("http://"+session.IP+":22222/category/"+category, ProductsEntityDTO[].class);
			List<ProductsEntityDTO> beanResult = Arrays.asList(products);
			this.allProducts=beanResult;

			if(category.equals("Phone")) {
				return "Phone";
		
			}else if(category.equals("Accessories")) {
				return "Accessories";
			}else {
				return "error";
			}
		}catch(Exception e) {
			   e.printStackTrace();
			   return "error";
		}

		//return SUCCESS;
	}
	
}
