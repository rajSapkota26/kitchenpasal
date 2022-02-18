package com.kitchenpasal.main.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenpasal.main.model.Category;
import com.kitchenpasal.main.repository.CategoryRepository;
import com.kitchenpasal.main.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public boolean saveCategory(Category category) throws Exception {
		String id = UUID.randomUUID().toString();
		Category category2 = categoryRepo.findByName(category.getName());
		if (category2 != null) {
			throw new Exception("Category Already exist!!");
		} else {
			category.setId(id);
			categoryRepo.save(category);
			return true;
		}

	}

	@Override
	public boolean deleteCategory(String id) {
		Category category = categoryRepo.findById(id).get();
		categoryRepo.delete(category);
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		categoryRepo.save(category);
		return true;
	}

	@Override
	public Category getCategoryById(String id) {
		Category category = categoryRepo.findById(id).get();
		return category;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

}
