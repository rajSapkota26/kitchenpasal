package com.kitchenpasal.main.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kitchenpasal.main.model.Product;
import com.kitchenpasal.main.model.SubCategory;

public interface ProductRepository extends JpaRepository<Product, String>{

	List<Product> findBySubCategory(SubCategory sucat);
	
	Page<Product> findByIsoffer(boolean isoffer,Pageable pageable);
//	Page<Product> findByIsoffer(Pageable pageable);
	Page<Product> findByIsfeature(boolean ispopular,Pageable pageable);
//	Page<Product> findByIsfeature(Pageable pageable);
	Page<Product> findByIspopular(boolean isfeature,Pageable pageable);
	Page<Product> findByNameContaining(String keyword,Pageable pageable);
	
	
	
	
	
	@Query("from Product as p where p.subCategory.id=:sub_category_id")
	Page<Product> findBySubCategoryId(@Param("sub_category_id")String sub_category_id,Pageable pageable);
	
	
	
	Page<Product> findByCategoryId(String categoryId,Pageable pageable);
	
	
	
	
	
	Page<Product> findByOrderByNameAsc(Pageable pageable);
	Page<Product> findByOrderByNameDesc(Pageable pageable);
	Page<Product> findByOrderByPriceAsc(Pageable pageable);
	Page<Product> findByOrderByPriceDesc(Pageable pageable);
	

}
