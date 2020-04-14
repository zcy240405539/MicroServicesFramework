package com.framework.jpa;

public class ProductsEntityDTO {
	String pid;
	String pname;
	String price;
	String category;
	String picture;	
	String detail;
	
	public ProductsEntityDTO(){}

	public ProductsEntityDTO(String pid) {
		this.pid = pid;
	}
	
	public ProductsEntityDTO(String pid, String pname, String price, String category, String picture, String detail) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category = category;
		this.picture=picture;
		this.detail=detail;
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

	public String toString()
	{
		return "Product:"+pid+",Name:"+pname ;
	}

}
