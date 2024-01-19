package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.User;
import com.ecommerce.util.Response;

public interface UserService {
	public Response register(User user);

	public Response login(User user);

	public List<User> get();

	public Response ChangePassword(User user);

	

	public Response ForgotPassword(User user);

	
}
