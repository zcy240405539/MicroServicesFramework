package com.framework.jpa;

public class BillsEntityDTO {
	String orderid;	
	String userid;
	String card;
	String cardname;
	String datemonth;
	String dateyear;
	String totalPrice;
	
	public BillsEntityDTO(){}
	
	public BillsEntityDTO(String orderid){
		this.orderid = orderid;
	}
	
	public BillsEntityDTO(String orderid, String userid, String card, String cardname, String datemonth, String dateyear, String totalPrice){
		this.orderid = orderid;
		this.userid = userid;
		this.card = card;
		this.cardname = cardname;
		this.datemonth = datemonth;
		this.dateyear = dateyear;
		this.totalPrice = totalPrice;
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

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getDatemonth() {
		return datemonth;
	}

	public void setDatemonth(String datemonth) {
		this.datemonth = datemonth;
	}

	public String getDateyear() {
		return dateyear;
	}

	public void setDateyear(String dateyear) {
		this.dateyear = dateyear;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
