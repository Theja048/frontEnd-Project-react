package com.ecommerce.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.util.Response;
import com.util.EmailUtil;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private EntityManager entityManager;
	javax.mail.Session sessiontwo;

	@Override
	public Response PlaceOrder(Order order) {
		Response response = new Response();
		Session session=entityManager.unwrap(Session.class);
		int i=(int) session.save(order);
		if(i!=0) {
			response.setMessage("order succcessful");
			response.setOperation(true);
			response.setStatusCode(200);
			return response;
		}
		else {
			response.setMessage("order failure");
			response.setOperation(false);
			response.setStatusCode(500);
			return response;
			
		}
		
	}
 
	@Override
	public List<Order> get() {
		Session session = entityManager.unwrap(Session.class);
		List<Order> list = session.createQuery("from Order").list();
		return list;
		
		
	}
	
	@Override
	public Order getOrderByUserid(int userId) {
	System.out.println("userId in dao" + userId);
	Session session = entityManager.unwrap(Session.class);
	Order order = session.get(Order.class, userId);
	return order;
	}


	@Override
	public List<Order> getMultipleOrdersByid() {
	Session session = entityManager.unwrap(Session.class);
	String s ="from Order where userid=1";
	
	List<Order> list = session.createQuery(s,Order.class).list();
	return list;


	}

	
	
	}

	

	



