package com.kitchenpasal.main.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenpasal.main.model.Category;
import com.kitchenpasal.main.model.SubCategory;
import com.kitchenpasal.main.repository.CategoryRepository;
import com.kitchenpasal.main.repository.SubCategoryRepository;
import com.kitchenpasal.main.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	CategoryRepository catRepo;
	@Autowired
	SubCategoryRepository subcatRepo;

	@Override
	public boolean saveCategory(String catId,SubCategory category) throws Exception {
		String id = UUID.randomUUID().toString();
		Category cat = catRepo.findById(catId).get();
		SubCategory category2 = subcatRepo.findByName(category.getName());
		if (category2 != null) {
			throw new Exception("this sub category Already exist!!");
		} else {
			category.setId(id);
			category.setCategory(cat);
			subcatRepo.save(category);
			return true;
		}
		
	}

	@Override
	public boolean deleteCategory(String category) {
		SubCategory subCategory = subcatRepo.findById(category).get();
		subcatRepo.delete(subCategory);
		return true;
	}

	@Override
	public boolean updateCategory(String catId,SubCategory category) {
		Category category2 = catRepo.findById(catId).get();
		category.setCategory(category2);
		subcatRepo.save(category);
		return true;
	}

	@Override
	public SubCategory getSubCategoryById(String id) {
		// TODO Auto-generated method stub
		return subcatRepo.findById(id).get();
	}

	@Override
	public List<SubCategory> getAllSubCategoryByCategory(String categoryId) {
		 Category category = catRepo.findById(categoryId).get();
		 List<SubCategory> list = subcatRepo.findByCategory(category);
		return list;
	}

}
