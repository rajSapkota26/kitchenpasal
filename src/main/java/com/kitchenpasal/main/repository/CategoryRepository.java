package com.kitchenpasal.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitchenpasal.main.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

	Category findByName(String name);

}
