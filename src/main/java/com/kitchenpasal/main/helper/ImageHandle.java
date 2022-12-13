package com.kitchenpasal.main.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import com.kitchenpasal.main.model.ImageFile;

public class ImageHandle {

	public static ImageFile uploadImage(MultipartFile file) {
		ImageFile imageFile=new ImageFile();
		

		try {
			if (!file.isEmpty()) {
				String id = UUID.randomUUID().toString();
				String name = UUID.randomUUID().toString() + file.getOriginalFilename();
				File file2 = new ClassPathResource("static/img").getFile();
				Path savepath = Paths.get(file2.getAbsolutePath() + File.separator + name);
				Files.copy(file.getInputStream(), savepath, StandardCopyOption.REPLACE_EXISTING);
				imageFile.setId(id);
				imageFile.setName(name);
				return imageFile;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;

	}

	public static List<ImageFile> uploadImages(List<MultipartFile> files) {
		// getting new image
		List<ImageFile> myList = new ArrayList<>();
		try {
			for (MultipartFile file : files) {
				ImageFile imageFile = new ImageFile();
				String id = UUID.randomUUID().toString();
				String name = UUID.randomUUID().toString() + file.getOriginalFilename();
				File file2 = new ClassPathResource("static/img").getFile();
				Path savepath = Paths.get(file2.getAbsolutePath() + File.separator + name);
				Files.copy(file.getInputStream(), savepath, StandardCopyOption.REPLACE_EXISTING);
				imageFile.setId(id);
				imageFile.setName(name);
               myList.add(imageFile);
			}
			return myList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
