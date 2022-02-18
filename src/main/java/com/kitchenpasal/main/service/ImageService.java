package com.kitchenpasal.main.service;

import com.kitchenpasal.main.model.ImageFile;

public interface ImageService {
	public boolean saveImage(ImageFile imageFile);
	public boolean deleteImage(ImageFile imageFile);

}
