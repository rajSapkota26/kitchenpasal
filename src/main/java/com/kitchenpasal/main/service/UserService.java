package com.kitchenpasal.main.service;

import com.kitchenpasal.main.model.User;

public interface UserService {

	User findbyUserName(String username);
	void saveUser(User user) throws Exception;
	void saveHr(User user)throws Exception;
}
