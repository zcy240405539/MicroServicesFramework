package com.framework.jpa;

import java.util.List;

public class OrdersEntityDTO {
	String orderid;
	String userid;
	String totalPrice; 
	String orderTime;
	String ip;
	List<ItemsEntityDTO> item;
	
	public OrdersEntityDTO(){}
	
	public OrdersEntityDTO(String orderid){
		this.orderid = orderid;
	}

	public OrdersEntityDTO(String orderid, String userid, String totalPrice, String orderTime, String ip, List<ItemsEntityDTO> item){
		this.orderid = orderid;
		this.userid = userid;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.ip = ip;
		this.item = item;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<ItemsEntityDTO> getItem() {
		return item;
	}

	public void setItem(List<ItemsEntityDTO>  item) {
		this.item = item;
	}
	
	
}
