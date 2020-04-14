package com.framework.business;

import java.util.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.framework.jpa.ShopEntityDTO;

@Component
@Scope("session")
public class CustomerSession {
	//http://localhost/add2Cart?prodName=nokia
	public ArrayList<ShopEntityDTO> cart=new ArrayList<ShopEntityDTO> ();
	public boolean isCustomerLoggedin=false;
	public String currentUser=null;

}
