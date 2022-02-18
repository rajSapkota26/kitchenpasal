package com.kitchenpasal.main.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.kitchenpasal.main.model.Product;

public interface ProductService {
	public boolean saveProduct(String subcatId, Product product,List<MultipartFile> files) throws Exception;

	public boolean deleteProduct(String category);
	
	public boolean updateProduct(String subcatId, Product product,List<MultipartFile> files);
	
	public Product getProductById(String id);
	
	public List<Product> getAllProductBysubCategory(String productId);
	
	public List<Product> getAllProductBysubCategory();
	
	public Page<Product> getAllProductByFeature(boolean b,int page);
	
	public Page<Product> getAllProductByPopular(boolean b,int page);
	
	public Page<Product> getAllProductByOffer(boolean b,int page);
	public Page<Product> getAllProductByFeature(int page);
	
	public Page<Product> getAllProductByPopular(int page);
	
	public Page<Product> getAllProductByOffer(int page);
	
	public Page<Product> getAllProductByCategory(String catId,int page);
	
	public Page<Product> getAllProductByCategoryAndSubCategory(int page,String subcatId);
	public Page<Product> getAllProducts(int page,String catId,String subcatId);
	
	

}
