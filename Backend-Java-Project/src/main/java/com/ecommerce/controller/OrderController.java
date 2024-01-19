package com.ecommerce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.OrderService;

import com.ecommerce.util.Response;
@RequestMapping("/order")
@RestController
public class OrderController {
	@Autowired
	 OrderService orderservice;
	@CrossOrigin
	@PostMapping("/PlaceOrder")
	public ResponseEntity<Response>  PlaceOrder(@RequestBody Order order) {
		
		  Response response =  orderservice.PlaceOrder(order);
	
		if(response.getOperation()== true) {
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
			
		}
			
	}
	@CrossOrigin
	@GetMapping("/list")
	 public ResponseEntity<List<Order>> getAllOrders() {
		
		  List<Order> result =  orderservice.get();
		  
		  return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
	 }
	@CrossOrigin
	@PostMapping("/orderByuserId/{id}")
	public ResponseEntity<Order> getOrderbyuserId(@PathVariable("id") int id){
		    System.out.println("userid"+ id);
		Order result = orderservice.getOrderByUserid(id);
		 return new ResponseEntity<Order>(result, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/orderlist")
	public ResponseEntity<List<Order>> getMultipleOrdersByid() {

	List<Order> result = orderservice.getMultipleOrdersByid();
	
	return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
	}
}


