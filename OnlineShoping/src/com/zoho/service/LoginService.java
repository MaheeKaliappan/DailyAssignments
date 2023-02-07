package com.zoho.service;
import com.zoho.model.User;

public class LoginService {

	public User addAdmin() {
		User user = new User();
		user.setPersonName("admin");
		user.setPersonPassword("benjo");
		user.setPersonRole("ADMIN");
		return user;
		
	}

}
