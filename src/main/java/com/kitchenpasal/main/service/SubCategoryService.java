package com.kitchenpasal.main.service;

import java.util.List;

import com.kitchenpasal.main.model.SubCategory;

public interface SubCategoryService {
	public boolean saveCategory(String catId,SubCategory category)throws Exception;
	public boolean deleteCategory(String category);
	public boolean updateCategory(String catId,SubCategory category);
	public SubCategory getSubCategoryById(String id);
	public List<SubCategory> getAllSubCategoryByCategory(String categoryId);
}
