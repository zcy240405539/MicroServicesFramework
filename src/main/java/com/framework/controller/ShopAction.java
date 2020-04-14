package com.framework.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.framework.business.CustomerSession;
import com.framework.jpa.*;

public class ShopAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	public String prodID;
	public String prodCount;
	public String prodPrice;
	public String prodName;
	public String prodPicture;	
	public double totalPrice;
	public double subTotal;
	//public String allProducts;
	public List<ShopEntityDTO> allItems = new ArrayList<ShopEntityDTO>();
	@Autowired
	CustomerSession session;

	public String Add() {
		try {
			ShopEntityDTO order = new ShopEntityDTO(prodID, prodName, prodPicture, Integer.parseInt(prodCount), Double.parseDouble(prodPrice));
			
			if (checkProduct(order) != true) {
				session.cart.add(order);
				totalPrice = Double.parseDouble(prodPrice)*(double)Integer.parseInt(prodCount);
				order.setTotalPrice(totalPrice);
			}

			for (int i = 0; i < session.cart.size(); i++) {
				System.out.println(session.cart.get(i).getProdID() + " " + session.cart.get(i).getProdName() + " " + session.cart.get(i).getProdCount() + " $"
						+ session.cart.get(i).getProdPrice() + " $" + session.cart.get(i).getTotalPrice());
				
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}
	
	// Check if the item exist in cart
	public boolean checkProduct(ShopEntityDTO item) {
		boolean result = false;
		for (int i = 0; i < session.cart.size(); i++) {
			// session.cart.get(i);
			if (session.cart.get(i).getProdID().equals(item.getProdID())) {
				int currentCount = session.cart.get(i).getProdCount();
				currentCount += item.getProdCount();
				item.setProdCount(currentCount);
				totalPrice = (double)currentCount*item.getProdPrice();
				item.setTotalPrice(totalPrice);
				session.cart.set(i, item);
				result = true;
				break;
			}
		}
		return result;
	}
	
	public String Update() {
		try {
			//ShopEntityDTO item = new ShopEntityDTO(prodID, Integer.parseInt(prodCount));
			
			for (int i = 0; i < session.cart.size(); i++) {
				if (session.cart.get(i).getProdID().equals(prodID)) {
					ShopEntityDTO item = session.cart.get(i);
					int totalNumber=Integer.parseInt(prodCount);				
					double totalPrice = totalNumber*item.getProdPrice();
					if(totalNumber > 0) {
						item.setProdCount(totalNumber);
						item.setTotalPrice(totalPrice);
						session.cart.set(i, item);
						break;
					}else {
						session.cart.remove(i);
						break;
					}
				}
				
				System.out.println(session.cart.get(i).getProdID() + " " + session.cart.get(i).getProdCount() + " $"
						+ session.cart.get(i).getProdPrice()+" "+this.subTotal);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String Destroy() {
		try {
			//ShopEntityDTO item = new ShopEntityDTO(prodID, Integer.parseInt(prodCount));

			for (int i = 0; i < session.cart.size(); i++) {
				if (session.cart.get(i).getProdID().equals(prodID)) {
					session.cart.remove(i);
					break;
				}
				
				System.out.println(session.cart.get(i).getProdID() + " " + session.cart.get(i).getProdCount() + " $"
						+ session.cart.get(i).getProdPrice());
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String shoppingCart() {
		try {
			if(allItems.size()==0) {
				this.allItems=session.cart;
				this.subTotal=0;
				for (int i = 0; i < allItems.size(); i++) {
					this.subTotal += allItems.get(i).getTotalPrice();
					System.out.println(allItems.get(i).getProdID() + " " + allItems.get(i).getProdName() + " " + allItems.get(i).getProdCount() + " $"
							+ allItems.get(i).getProdPrice() + " $" + allItems.get(i).getTotalPrice());
				}
			
				return SUCCESS;
			}else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public void setProdID(String prodID) {
		this.prodID = prodID;
	}

	public void setProdCount(String prodCount) {
		this.prodCount = prodCount;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public void setProdPicture(String prodPicture) {
		this.prodPicture = prodPicture;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setAllItems(List<ShopEntityDTO> allItems) {
		this.allItems = allItems;
	}

	public List<ShopEntityDTO> getAllItems() {
		return allItems;
	}

	public void setSession(CustomerSession session) {
		this.session = session;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
