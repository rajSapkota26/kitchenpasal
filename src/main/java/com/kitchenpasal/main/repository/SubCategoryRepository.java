package com.kitchenpasal.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitchenpasal.main.model.Category;
import com.kitchenpasal.main.model.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String>{

	List<SubCategory> findByCategory(Category category);

	SubCategory findByName(String name);

}
