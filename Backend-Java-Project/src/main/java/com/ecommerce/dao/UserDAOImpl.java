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

import com.ecommerce.model.User;
import com.ecommerce.util.Response;
import com.util.EmailUtil;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private EntityManager entityManager;
	javax.mail.Session sessiontwo;

	@Override
	public Response register(User user) {
		Response response = new Response();
		Session session=entityManager.unwrap(Session.class);
		int i=(int) session.save(user);
		if(i!=0) {
			response.setMessage("user register succcessful");
			response.setOperation(true);
			response.setStatusCode(200);
			return response;
		}
		else {
			response.setMessage("user register failure");
			response.setOperation(false);
			response.setStatusCode(500);
			return response;
			
		}
		
	}

	
	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		List<User> list = session.createQuery("from User").list();
		return list;
	}


	@Override
	public Response login(User user) {
		Response response = new Response();
		boolean isUsernameMatched = false;
		boolean isPasswordMatched = false;
		Session currentsession=entityManager.unwrap(Session.class);
		
		String u = "from User";
		Query query =currentsession.createQuery(u,User.class);
		List<User> users = query.getResultList();
		String role="";
		Iterator iterator = users.iterator();
		while(iterator.hasNext()) {
			User user1 = (User)iterator.next();
			
			if(user1.getUsername().contentEquals(user.getUsername())) {
				isUsernameMatched = true;
				if(user1.getPassword().contentEquals(user.getPassword())){
					isPasswordMatched = true;
					role = user1.getRole();
					break;
					
				}
			}
			
		}
		
		if( isUsernameMatched == true && isPasswordMatched == true) {
			response.setMessage("login success");
			response.setOperation(true);
			response.setStatusCode(200);
			response.setRole(role);
			
			
		}
		if(isUsernameMatched == true && isPasswordMatched == false) {
			response.setMessage("incorrect password");
			response.setOperation(true);
			response.setStatusCode(401);
			response.setRole(role);
			
			
		}
		if(isUsernameMatched == false) {
			response.setMessage("invalid user");
			response.setOperation(true);
			response.setStatusCode(401);
			
		
		}
	return response;
	
	}
			
		
		//update User1 user set e = user.setPassword where s.username=;
	
		@Override
	public Response ChangePassword(User user) {
		Response response = new Response();
		boolean isUsernameMatched = false;
		boolean isPasswordMatched = false;
		Session currentsession=entityManager.unwrap(Session.class);
		
		//update logic
		Transaction tx=currentsession.beginTransaction();  
		Query q=currentsession.createQuery("update User set password=:n where username=:i");  
		q.setParameter("n",user.password);  
		q.setParameter("i",user.username);  
		  
		int status=q.executeUpdate();  
		System.out.println(status);
		tx.commit(); 
		
	
if(status!=0) {
	response.setMessage("change password success");
	response.setOperation(true);
	response.setStatusCode(200);
	
}
else {
	response.setMessage("change password failure");
	response.setOperation(false);
	response.setStatusCode(401);
	
}


return response;
	
	}


		@Override
		
		public Response ForgotPassword(User user) {
			Response response = new Response();
			Session session = entityManager.unwrap(Session.class);
			boolean isEmailMatched=false;
			String s2="from User";
			Query query = session.createQuery(s2,User.class);
			List<User> employees = query.getResultList();
			
			Iterator iterator = employees.iterator();
			while(iterator.hasNext()) {
			User user1=	(User) iterator.next();
			System.out.println(user1.getEmail());
			if(user.getEmail().contentEquals(user1.getEmail())) {
				isEmailMatched=true;
				
				break;
				}
			}
			
			if(isEmailMatched==true ) {
				final String fromEmail = "k10730024@gmail.com"; //requires valid gmail id
				final String password = "zwijuwjowoyvxadb"; // correct password for gmail id
				final String toEmail = "saiteja182415@gmail.com"; // can be any email id 
				
				System.out.println("TLSEmail Start");
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
				props.put("mail.smtp.port", "587"); //TLS Port
				props.put("mail.smtp.auth", "true"); //enable authentication
				props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
				
		                //create Authenticator object to pass in Session.getInstance argument
				Authenticator auth = new Authenticator() {
					//override the getPasswordAuthentication method
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
				};
				sessiontwo.getInstance(props, auth);
				
				EmailUtil.sendEmail(sessiontwo, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");
				
				response.setMessage(" user Email sent succesfully");
				response.setOperation(true);
				response.setStatusCode(200);
				
			}
			else {
				response.setMessage("user Email is not sent succesfully ");
				response.setOperation(false);
				response.setStatusCode(401);
			}
			
			return response;
		}
		

		

		

	}

	

	



