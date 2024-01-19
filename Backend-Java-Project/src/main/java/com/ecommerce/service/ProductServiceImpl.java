package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;
import com.ecommerce.util.Response;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDAO;
	

    @Transactional
	public Response add(Product product) {
		
		  return productDAO.add(product);
	}

    @Transactional
	public List<Product> get() {
		// TODO Auto-generated method stub
		return productDAO.get();
	}

    @Transactional
	public Product getByid(int id) {
		// TODO Auto-generated method stub
		return productDAO.getByid(id);
	}

    @Transactional
	public Response update(Product product) {
    	return productDAO.update(product);
		
	}

    @Transactional
	public Response delete(int id) {
		// TODO Auto-generated method stub
    	System.out.println("service");
    	productDAO.delete(id);
		return productDAO.delete(id); 
		
	}
	

}
