package com.kitchenpasal.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitchenpasal.main.model.ImageFile;

public interface ImageFileRepository extends JpaRepository<ImageFile, String>{
	
	

}
