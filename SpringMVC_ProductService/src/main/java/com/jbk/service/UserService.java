package com.jbk.service;

import com.jbk.entity.User;

public interface UserService {
	
	public Boolean addUser(User user);
	public Boolean updateUser(User user);
	public User getUserById(String username);

}
