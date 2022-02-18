package com.kitchenpasal.main.service;

import java.util.List;

import com.kitchenpasal.main.model.SliderItems;

public interface SliderItemsService {

	void save(SliderItems slider);
	List<SliderItems> getAllSlider( );
	SliderItems getSliderById(String id );
	void delete(String id);
}
