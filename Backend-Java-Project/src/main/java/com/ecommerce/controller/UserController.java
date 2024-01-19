package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import com.ecommerce.util.Response;
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@CrossOrigin
	@PostMapping("/register")
	public ResponseEntity<Response>  register(@RequestBody User user) {
		System.out.println("username"+user.getUsername());
		Response response= userService.register(user);
		if(response.getOperation()== true) {
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
			
		}
			
	}
	@CrossOrigin
	@GetMapping("/list")
	 public ResponseEntity<List<User>> getAllProducts() {
		
		  List<User> result =  userService.get();
		  
		  return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	

}
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody User user) {
		 System.out.println("username"+user.getUsername());
		Response response= userService.login(user);
		if(response.getOperation()== true) {
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
			
		}
			
	}
	
	@CrossOrigin
	@PutMapping("/ChangePassword")
	 public ResponseEntity ChangePassword (@RequestBody User user) {
		Response response = userService.ChangePassword(user);
		   if(response.getOperation()== true) {
				return new ResponseEntity<Response>(response,HttpStatus.OK);
				}
				else {
					return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
				
			}
	 }

	@CrossOrigin
	@PostMapping("/getByemail")
	 public ResponseEntity<Response> ForgotPassword(@RequestBody User user) {
		
		  Response result =  userService.ForgotPassword(user);
		  
		  Response response = userService.ForgotPassword(user);
		   if(response.getOperation()== true) {
				return new ResponseEntity<Response>(response,HttpStatus.OK);
				}
				else {
					return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
				
			
	 }
	
	
	  }
}
	


