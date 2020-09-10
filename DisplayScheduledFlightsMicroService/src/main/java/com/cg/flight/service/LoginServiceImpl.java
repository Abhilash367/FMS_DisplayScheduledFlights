package com.cg.flight.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flight.dao.ILoginDao;
import com.cg.flight.entity.User;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.util.FlightConstants;

@Service
public class LoginServiceImpl  implements  ILoginService{
	
	
	@Autowired
	private ILoginDao dao;
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Override
	public User doLogin(String contactNo, String password) throws LoginException {
		User user = null;
		logger.debug("doing login process");
		Optional<User> optUser = dao.findById(contactNo);
		
		if(optUser.isPresent()) {
			user = optUser.get();
			if(!user.getPassword().contentEquals(password))
					throw new LoginException(FlightConstants.PASS_NOT_VALID);
			logger.info("User Authenticated for " + contactNo);
			return user;
		}
		throw new LoginException(FlightConstants.USER_NOT_VALID);
		
	
	}

	@Override
	public String encryptUser(User user) {
		
		return encryptString(user.getContactNo())+ "-" +encryptString(user.getUserName())+"-" 
		+encryptString(user.getRole());
	}
	
	public String encryptString(String str) {
		
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]+3;
			sb.append((char)ch);
		}
		
		return sb.toString();
	}
	
	public String decryptString(String str) {
		
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch;
		for(int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]-3;
			sb.append((char)ch);
		}
		
		return sb.toString();
		
		
	}

}