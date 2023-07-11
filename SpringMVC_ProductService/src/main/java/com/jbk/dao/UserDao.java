package com.jbk.dao;

import com.jbk.entity.User;

public interface UserDao {
	public Boolean addUser(User user);

	public Boolean updateUser(User user);

	public User getUserById(String username);

}
