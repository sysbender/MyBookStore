package com.voxwalker.bookstore.service;



import com.voxwalker.bookstore.dao.UserDao;
import com.voxwalker.bookstore.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public void regist(User form) throws UserException{
		
		// validate username
		User user = userDao.findByUsername(form.getUsername());
		if(user != null){
			System.out.println("=========== input validate : ok");
			throw new UserException("User exist:" +form.getUsername());
		}
		
		// validate email
		user = userDao.findByEmail(form.getEmail());
		if(user!=null) {
			throw new UserException("email exist :" + form.getEmail());
		}
		
		// add user from form input
		try{
		userDao.add(form);
		}catch(Exception e){
			throw new UserException("add user fail: " + e.getMessage());
		}
		
	}
	
	/**
	 * check username and password
	 * @param form
	 * @return user
	 * @throws UserException
	 */
	public User login(User form) throws UserException{
		
		User user = userDao.findByUsername(form.getUsername());
		
		if(user == null) {
			throw new UserException("user not exist!");
		}
		
		if(! user.getPassword().equals(form.getPassword())){
			throw new UserException("password not match!");
		}
		
		/*
		if(! user.isState()){
			throw new UserException("user not activated!");
		}
		*/
		System.out.println("user==========" + user);
		return user;
	}
	
}
