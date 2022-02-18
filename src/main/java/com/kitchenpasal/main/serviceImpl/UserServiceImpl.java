package com.kitchenpasal.main.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kitchenpasal.main.model.User;
import com.kitchenpasal.main.repository.UserRepository;
import com.kitchenpasal.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder PasswordEncoder;
	@Override
	public User findbyUserName(String username) {

		return userRepo.getUserByUserName(username);
	}
	@Override
	public void saveUser(User user) throws Exception {
		User local = userRepo.getUserByUserName(user.getEmail());
		if (local !=null) {
			throw new Exception("user already exist");
		}
		 String id = UUID.randomUUID().toString();
		 user.setId(id);
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		 userRepo.save(user);
		
	}
	@Override
	public void saveHr(User user) throws Exception {
		 String id = UUID.randomUUID().toString();
		 user.setId(id);
		user.setRole("ROLE_HR");
		user.setEnabled(true);
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		 userRepo.save(user);
		
	}

}
