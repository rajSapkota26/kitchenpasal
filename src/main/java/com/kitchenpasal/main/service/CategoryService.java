package com.kitchenpasal.main.service;

import java.util.List;

import com.kitchenpasal.main.model.Category;

public interface CategoryService {

	public boolean saveCategory(Category category)throws Exception;
	public boolean deleteCategory(String categoryId);
	public boolean updateCategory(Category category);
	public Category getCategoryById(String id);
	public List<Category> getAllCategory();
	
	
}
