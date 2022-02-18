package com.kitchenpasal.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	private String id;
	private String categoryId;
	private String name;
	private double mrpPrice;
	private double price;
	private String sku;
	@Column(length = 2000)
	private String description;
	private String brand;
	@Column(length = 2000)
	private String specification;
	@Column(length = 2000)
	private String services;
	private String color;
	private String pPize;
	private String unit;
	private boolean isAvilable;
	private boolean isfeature;
	private boolean ispopular;
	private boolean isoffer;
	@ManyToOne
	private SubCategory subCategory;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
	private List<ImageFile> imageFiles;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
	private VideoFile videoFile;
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
	public double getMrpPrice() {
		return mrpPrice;
	}
	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getpPize() {
		return pPize;
	}
	public void setpPize(String pPize) {
		this.pPize = pPize;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public boolean isAvilable() {
		return isAvilable;
	}
	public void setAvilable(boolean isAvilable) {
		this.isAvilable = isAvilable;
	}
	public boolean isIsfeature() {
		return isfeature;
	}
	public void setIsfeature(boolean isfeature) {
		this.isfeature = isfeature;
	}
	public boolean isIspopular() {
		return ispopular;
	}
	public void setIspopular(boolean ispopular) {
		this.ispopular = ispopular;
	}
	public boolean isIsoffer() {
		return isoffer;
	}
	public void setIsoffer(boolean isoffer) {
		this.isoffer = isoffer;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public List<ImageFile> getImageFiles() {
		return imageFiles;
	}
	public void setImageFiles(List<ImageFile> imageFiles) {
		this.imageFiles = imageFiles;
	}
	public VideoFile getVideoFile() {
		return videoFile;
	}
	public void setVideoFile(VideoFile videoFile) {
		this.videoFile = videoFile;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", mrpPrice=" + mrpPrice + ", price=" + price + ", sku=" + sku
				+ ", description=" + description + ", brand=" + brand + ", specification=" + specification
				+ ", services=" + services + ", color=" + color + ", pPize=" + pPize + ", unit=" + unit
				+ ", isAvilable=" + isAvilable + ", isfeature=" + isfeature + ", ispopular=" + ispopular + ", isoffer="
				+ isoffer + ", subCategory=" + subCategory + ", imageFiles=" + imageFiles + ", videoFile=" + videoFile
				+ "]";
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
}
