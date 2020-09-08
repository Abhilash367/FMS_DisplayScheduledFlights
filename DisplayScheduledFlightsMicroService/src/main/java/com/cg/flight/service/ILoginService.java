package com.cg.flight.service;

import com.cg.flight.entity.User;
import com.cg.flight.exceptions.LoginException;

public interface ILoginService {
	
	public User doLogin(String contactNo, String password) throws LoginException;
	public String encryptUser(User user);
	

}
