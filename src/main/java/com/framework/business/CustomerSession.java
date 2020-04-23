package com.framework.business;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.framework.jpa.ShopEntityDTO;

@Component
@Scope("session")
public class CustomerSession {
	// product
	@Value("${microservices.ip}")
	public String IP;
	// development
	//public final String IP="localhost";
	public ArrayList<ShopEntityDTO> cart=new ArrayList<ShopEntityDTO> ();
	public boolean isCustomerLoggedin=false;
	public String currentUser=null;
	public String ipAddress=null;

}
