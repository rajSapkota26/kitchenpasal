package com.kitchenpasal.main.service;

import java.util.List;

import com.kitchenpasal.main.model.Order;

public interface OrderService {

	public Order saveOrder(Order order,String username);
	public List<Order> getAllOrders();
	public List<Order> getAllOrdersByUser(String username);
	public Order getOrderOrderById(String oId);
	public boolean deleteOrder(String oId);
}
