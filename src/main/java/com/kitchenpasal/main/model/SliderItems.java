package com.kitchenpasal.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SliderItems {
	@Id
	private String id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "sliderItems")
	private List<ImageFile> imageFiles;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ImageFile> getImageFiles() {
		return imageFiles;
	}
	public void setImageFiles(List<ImageFile> imageFiles) {
		this.imageFiles = imageFiles;
	}
	
}
