package com.kitchenpasal.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kitchenpasal.main.model.User;
import com.kitchenpasal.main.repository.UserRepository;



@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = service.getUserByUserName(username);
		if (user==null) {
			throw new UsernameNotFoundException("couldnt found this user!!");
		}
		CustomUserDetail cUserDetail=new CustomUserDetail(user);
		
		return cUserDetail;
	}

}
