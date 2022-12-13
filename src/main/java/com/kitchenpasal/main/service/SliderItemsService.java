package com.kitchenpasal.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kitchenpasal.main.model.SliderItems;

public interface SliderItemsService {

	void save(SliderItems slider,MultipartFile multipartFile);
	List<SliderItems> getAllSlider( );
	SliderItems getSliderById(String id );
	void delete(String id);
}
