package com.kitchenpasal.main.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenpasal.main.model.Order;
import com.kitchenpasal.main.model.Product;
import com.kitchenpasal.main.repository.OrderRepository;
import com.kitchenpasal.main.repository.ProductRepository;
import com.kitchenpasal.main.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository ordRepo;
	
	@Autowired
	ProductRepository proRepo;

	@Override
	public Order saveOrder(Order order, String username) {
		order.setId(UUID.randomUUID().toString());
		order.setUsername(username);
		order.setStatus("Pending");
		order.setSubmitDate(new Date());
		
		return ordRepo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> list = ordRepo.findAll();
		for (Order order : list) {
			 Product product = proRepo.findById(order.getProductId()).get();
			order.setProduct(product);
			
		}
		return list;
	}

	@Override
	public List<Order> getAllOrdersByUser(String username) {
		List<Order> list = ordRepo.findByUsernameOrderBySubmitDateDesc(username);
		for (Order order : list) {
			 Product product = proRepo.findById(order.getProductId()).get();
			order.setProduct(product);
			
		}
		return list;
	}

	@Override
	public Order getOrderOrderById(String oId) {
		
		return ordRepo.findById(oId).get();
	}

	@Override
	public boolean deleteOrder(String oId) {
		// TODO Auto-generated method stub
		return false;
	}

}
