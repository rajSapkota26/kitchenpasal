package com.kitchenpasal.main.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kitchenpasal.main.model.Cart;
import com.kitchenpasal.main.model.MakeOrder;

public interface CartService {

	public void saveCart(String uId,String pId,int qnty)throws Exception;
	public void deleteCart(String cart);
	public List<Cart> getAllCartByUserId(String userId);
	
	public MakeOrder getMakeOrder(String id,String userId,HttpSession session);
	public MakeOrder getMakeOrderforCart(String id,String userId);
}
