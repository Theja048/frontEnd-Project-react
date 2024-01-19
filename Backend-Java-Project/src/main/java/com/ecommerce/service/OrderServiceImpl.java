package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.OrderDAO;
import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.util.Response;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;

@Transactional
	public Response PlaceOrder(Order order) {
		
		  return orderDAO.PlaceOrder(order);
	}

@Override
public List<Order> get() {
	
	return orderDAO.get(); 
}

@Override
public Order getOrderByUserid(int userid) {
	
	return orderDAO.getOrderByUserid(userid);
}


 
@Override
public List<Order> getMultipleOrdersByid() {

return orderDAO.getMultipleOrdersByid();
}



}




	
	
	

	

