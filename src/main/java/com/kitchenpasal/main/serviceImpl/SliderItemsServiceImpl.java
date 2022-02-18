package com.kitchenpasal.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenpasal.main.model.SliderItems;
import com.kitchenpasal.main.repository.SliderItemsRepository;
import com.kitchenpasal.main.service.SliderItemsService;

@Service
public class SliderItemsServiceImpl implements SliderItemsService {
	@Autowired
	SliderItemsRepository itemRepo;

	@Override
	public void save(SliderItems slider) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SliderItems> getAllSlider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SliderItems getSliderById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
