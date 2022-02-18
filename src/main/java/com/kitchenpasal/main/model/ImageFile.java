package com.kitchenpasal.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ImageFile {
	@Id
	private String id;
	private String name;
	@ManyToOne
	private Product product;
	@ManyToOne
	private SliderItems sliderItems;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public SliderItems getSliderItems() {
		return sliderItems;
	}
	public void setSliderItems(SliderItems sliderItems) {
		this.sliderItems = sliderItems;
	}
	
	
}
