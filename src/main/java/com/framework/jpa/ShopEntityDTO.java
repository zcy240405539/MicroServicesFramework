package com.framework.jpa;

public class ShopEntityDTO {
	public String prodName;
	public String prodID;
	public int prodCount;
	public String prodPicture;	
	public double prodPrice;
	public double totalPrice;
	
	public ShopEntityDTO() {
	}
	
	public ShopEntityDTO(String prodID, String prodName, String prodPicture, int prodCount, double prodPrice) {
		this.prodName = prodName;
		this.prodID = prodID;
		this.prodCount = prodCount;
		this.prodPrice= prodPrice;
		this.prodPicture = prodPicture;
	}
	
	public ShopEntityDTO(String prodID, int prodCount) {
		this.prodID = prodID;
		this.prodCount = prodCount;
	}
	
	public String getProdID() {
		return prodID;
	}
	public void setProdID(String prodID) {
		this.prodID = prodID;
	}
	public int getProdCount() {
		return prodCount;
	}
	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}

	public double getProdPrice() {
		return prodPrice;
	}
	
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdPicture() {
		return prodPicture;
	}

	public void setProdPicture(String prodPicture) {
		this.prodPicture = prodPicture;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	
}
