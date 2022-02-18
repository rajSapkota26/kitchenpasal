package com.kitchenpasal.main.security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		 Iterator<? extends GrantedAuthority> iterator = authentication.getAuthorities().iterator();
	        boolean isAdmin=false;
	        while (iterator.hasNext()) {
	            if (iterator.next().getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
	                isAdmin = true;
	            }
	        }
	        if (isAdmin) {
	            response.sendRedirect("/myadmin/index");

	        } else {
	            response.sendRedirect("/");
	        }
		
	}

}
