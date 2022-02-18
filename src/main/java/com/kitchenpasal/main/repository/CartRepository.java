package com.kitchenpasal.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kitchenpasal.main.model.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

	@Query("SELECT c FROM Cart c WHERE c.productId = ?1 and c.userId = ?2")
	Cart findByProductIdAndUserId(String pId,String uId) ;
	List<Cart> findByUserId(String uId);
}
