package com.kitchenpasal.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitchenpasal.main.model.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

	List<Order> findByUsernameOrderBySubmitDateDesc(String username);
}
