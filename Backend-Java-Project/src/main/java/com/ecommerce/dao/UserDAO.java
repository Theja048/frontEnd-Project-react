package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.User;
import com.ecommerce.util.Response;

public interface UserDAO {
	public Response register(User user);
	
	
	
	public List<User> get();



	public Response login(User user);

   public Response ChangePassword(User user);

public Response ForgotPassword(User user);






	



	

}
