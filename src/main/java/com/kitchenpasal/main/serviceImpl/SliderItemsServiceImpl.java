package com.kitchenpasal.main.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kitchenpasal.main.helper.ImageHandle;
import com.kitchenpasal.main.model.ImageFile;
import com.kitchenpasal.main.model.SliderItems;
import com.kitchenpasal.main.repository.SliderItemsRepository;
import com.kitchenpasal.main.service.SliderItemsService;

@Service
public class SliderItemsServiceImpl implements SliderItemsService {
	@Autowired
	SliderItemsRepository itemRepo;

	@Override
	public void save(SliderItems slider, MultipartFile multipartFile) {
		slider.setId(UUID.randomUUID().toString());
		ImageFile imageFile = ImageHandle.uploadImage(multipartFile);
		imageFile.setSliderItems(slider);
		List<ImageFile> imageFiles = new ArrayList<>();
		imageFiles.add(imageFile);
		slider.setImageFiles(imageFiles);
		itemRepo.save(slider);

	}

	@Override
	public List<SliderItems> getAllSlider() {
		// TODO Auto-generated method stub
		return itemRepo.findAll();
	}

	@Override
	public SliderItems getSliderById(String id) {
		// TODO Auto-generated method stub
		return itemRepo.findById(id).get();
	}

	@Override
	public void delete(String id) {
		SliderItems sliderItems = itemRepo.findById(id).get();
		List<ImageFile> imageFiles = sliderItems.getImageFiles();
		try {
			for (ImageFile img : imageFiles) {
				File file2 = new ClassPathResource("static/img/" + img.getName()).getFile();
				file2.delete();
			}
			itemRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
