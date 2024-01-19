package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.util.Response;

public interface OrderDAO {




public  Response PlaceOrder(Order order);

public List<Order>get();

public Order getOrderByUserid(int userId);

public List<Order> getMultipleOrdersByid();
}
	






	



	

//}
