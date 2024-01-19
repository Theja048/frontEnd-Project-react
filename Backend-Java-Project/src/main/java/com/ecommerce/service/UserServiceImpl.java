package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;
import com.ecommerce.util.Response;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Transactional
	@Override
	public Response register(User user) {
		return userDAO.register(user);
		
	}
	
	@Override
	public List<User> get() {
		
		return userDAO.get();
	}
	
	@Override
	public Response login(User user) {
		
		return userDAO.login(user);
	}

	@Override
	public Response ChangePassword(User user) {
		return userDAO.ChangePassword(user);
	}

	@Override
	public Response ForgotPassword(User user) {
		
		return userDAO.ForgotPassword(user);
	}

	

}
