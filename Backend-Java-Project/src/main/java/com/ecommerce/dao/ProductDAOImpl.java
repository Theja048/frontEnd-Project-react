package com.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ecommerce.model.Product;
import com.ecommerce.util.Response;

@Repository
public class ProductDAOImpl  implements ProductDAO{
	
	@Autowired
	 EntityManager entityManager;
		
	@Override
	public Response add(Product product) {
		Response response = new Response();
		Session session = entityManager.unwrap(Session.class);
		boolean status =  false;
		List<Product> list =  get();
		System.out.println("before list"+list.size());
		
		 
		  int i=(int) session.save(product);
			if(i!=0) {
				response.setMessage("product added sucessfully");
				response.setOperation(true);
				response.setStatusCode(200);
				return response;
			}
			else {
				response.setMessage("add product is failure");
				response.setOperation(false);
				response.setStatusCode(500);
				return response;
				
			}
			
		}

	@Override
	public List<Product> get() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		List<Product> list = session.createQuery("from Product").list();
		return list;
	}

	@Override
	public Product getByid(int id) {
		Response response = new Response();
		Session session = entityManager.unwrap(Session.class);
		Product product =  session.load(Product.class, id);
		return product;
	}


	@Override
	public Response update(Product product) {
		Response response = new Response();
		Session session = entityManager.unwrap(Session.class);
		 System.out.println("In productDAO Impl" + product);
		 
		session.update(product);
	   if(product !=null) {
		 response.setMessage("updated sucessfully");
		 response.setStatusCode(200);
		 response.setOperation(true);
	    }
	   else {
		   response.setMessage("updated failure");
			response.setOperation(false);
			response.setStatusCode(500);  
	   }
		 return response;
	}
	
	@Override
	public Response delete(int  id) {
		
		System.out.println("dao");
		     Response response = new Response();
				Session session = entityManager.unwrap(Session.class);
				Product product =  session.load(Product.class, id);
				session.delete(product);
				
				
				 //System.out.println(product);
				  if(product !=null) {
						 response.setMessage("deleted succfully");
						 response.setStatusCode(200);
						 response.setOperation(true);
					    }
					   else {
						   response.setMessage("updated failure");
							response.setOperation(false);
							response.setStatusCode(500);  
					   }
						 return response;
					
				 
				
	}

}
