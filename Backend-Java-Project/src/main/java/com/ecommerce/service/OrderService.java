package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.util.Response;

public interface OrderService {
	
   public  Response PlaceOrder(Order order);
   
   

public List<Order> get();
public Order getOrderByUserid(int Userid);

public List<Order> getMultipleOrdersByid();




}
