package com.framework.controller;

import java.text.SimpleDateFormat;
import java.util.*;

//import javax.servlet.http.HttpServletRequest;
import com.framework.jpa.*;
import com.framework.business.CustomerSession;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class OrderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	CustomerSession session;
	
	public String card;
	public 	String cardname;
	public String datemonth;
	public String dateyear;	
	public String orderid;
	public String userid;
	public String totalPrice; 
	public String orderTime;
	public String ip;
	public OrdersEntityDTO currentOrder;
	public List<OrdersEntityDTO> orders = new ArrayList<OrdersEntityDTO>();
	
	public String UserOrder() {
		try {
			if(session.isCustomerLoggedin) {
				userid  = session.currentUser;
				RestTemplate getTest = new RestTemplate();
				OrdersEntityDTO[] ordersEntityDTOs = getTest.getForObject("http://localhost:33333/checkOrderByUser/"+userid, OrdersEntityDTO[].class);
				List<OrdersEntityDTO> beanResult = Arrays.asList(ordersEntityDTOs);
				if(beanResult==null||beanResult.size()==0) {
					return ERROR;
				}else {
					orders = beanResult;					
					return SUCCESS;
				}

			}else {
				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String Bill() {
		return SUCCESS;	
	}

	public String addBill() {
		BillsEntityDTO billsEntityDTO = new BillsEntityDTO(orderid, userid, card, cardname, datemonth, dateyear, totalPrice);
		RestTemplate getTest = new RestTemplate();
		String result = getTest.postForObject("http://localhost:44444/addBill/", billsEntityDTO, String.class);
		
		if(result.equals("success"))
		{
			return "success";	
		}else {
			return "error";
		}
	}
	
	public String CheckOut() {
		try {
			RestTemplate getTest = new RestTemplate();
			ip= getIpAddress();
			System.out.println("ip: "+ this.ip);
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.orderTime = format.format(date);
			this.currentOrder = sessionToOrder(session.cart);
			
			String orderResult = getTest.postForObject("http://localhost:33333/checkOut/", this.currentOrder, String.class);
			String billResult = addBill();
			
			if(orderResult.equals("success") && billResult.equals("success"))
			{
				session.cart=new ArrayList<ShopEntityDTO> ();
				return SUCCESS;	
			}else {
				return ERROR;
			}
			
		}catch (Exception e) {
			System.out.println("ERROR checkout");
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String getIpAddress() {
		RestTemplate getTest = new RestTemplate();
		String result= getTest.getForObject("http://api.ipify.org", String.class);
		return result;
	}

	public OrdersEntityDTO sessionToOrder(ArrayList<ShopEntityDTO> shopEntityDTO) {
		List<ItemsEntityDTO> items = new ArrayList<ItemsEntityDTO>();
		String rawip = ip.replace(".", "");
		String raworderTime = orderTime.replace("-", "").replace(" ", "").replace(":", "");	
		this.orderid = raworderTime;
		
		if(session.isCustomerLoggedin) {
			this.orderid+=session.currentUser;
			this.userid  = session.currentUser;
		}else {
			this.orderid+=rawip;
			userid  = ip;
		}	
	
		for(ShopEntityDTO shop:shopEntityDTO) {
			ItemsEntityDTO item = shopToItem(shop);
			items.add(item);
		}
		
		OrdersEntityDTO order = new OrdersEntityDTO(orderid, userid, totalPrice,orderTime, ip, items);
		
		return order;	
	}
	
	
	public ItemsEntityDTO shopToItem(ShopEntityDTO shop) {
		ItemsEntityDTO item;
		RestTemplate getTest = new RestTemplate();
		ProductsEntityDTO product = getTest.getForObject("http://localhost:22222/checkProduct/"+shop.getProdID(), ProductsEntityDTO.class);
		if(orderid!=null && orderid!= "") {
			item = new ItemsEntityDTO(orderid, product, Integer.toString(shop.getProdCount()));
		}else {
			item = new ItemsEntityDTO("", product, Integer.toString(shop.getProdCount()));
		}
		if (totalPrice==null) {
			totalPrice = Double.toString(shop.getTotalPrice());
		}else {
			double sum = Double.valueOf(totalPrice);
			sum+=shop.getTotalPrice();
			totalPrice = Double.toString(sum);
		}
			
		return item;
	}
	
	public List<OrdersEntityDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrdersEntityDTO> orders) {
		this.orders = orders;
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

	public OrdersEntityDTO getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(OrdersEntityDTO currentOrder) {
		this.currentOrder = currentOrder;
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
	
}
