package com.framework.jpa;

public class ItemsEntityDTO {
	String orderid;
	ProductsEntityDTO product;
	String quantity; 

	public ItemsEntityDTO(){}
	
	public ItemsEntityDTO(String orderid, ProductsEntityDTO product, String quantity){
		this.orderid = orderid;
		this.product = product;
		this.quantity = quantity;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public ProductsEntityDTO getProduct() {
		return product;
	}

	public void setProduct(ProductsEntityDTO product) {
		this.product = product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	
}
