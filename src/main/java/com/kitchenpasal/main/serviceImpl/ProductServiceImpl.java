package com.kitchenpasal.main.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kitchenpasal.main.helper.ImageHandle;
import com.kitchenpasal.main.model.ImageFile;
import com.kitchenpasal.main.model.Product;
import com.kitchenpasal.main.model.SubCategory;
import com.kitchenpasal.main.repository.CategoryRepository;
import com.kitchenpasal.main.repository.ImageFileRepository;
import com.kitchenpasal.main.repository.ProductRepository;
import com.kitchenpasal.main.repository.SubCategoryRepository;
import com.kitchenpasal.main.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	SubCategoryRepository subcatRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	ImageFileRepository imageRepo;
	@Autowired
	CategoryRepository catRepo;

	@Override
	public boolean deleteProduct(String category) {
		Product product = productRepo.findById(category).get();
		List<ImageFile> imageFiles = product.getImageFiles();
		try {
			for (ImageFile img : imageFiles) {
				File file2 = new ClassPathResource("static/img/" + img.getName()).getFile();
				file2.delete();
			}
			productRepo.deleteById(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public boolean updateProduct(String subcatId, Product product, List<MultipartFile> files) {
		SubCategory subCategory = subcatRepo.findById(subcatId).get();
		Product p = productRepo.findById(product.getId()).get();
		if (files.get(0).getOriginalFilename().isEmpty()) {
			product.setSubCategory(subCategory);

			productRepo.save(product);
		} else {
			List<ImageFile> oldimages = p.getImageFiles();
			for (ImageFile img : oldimages) {
				try {
					File file2 = new ClassPathResource("static/img/" + img.getName()).getFile();
					file2.delete();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			productRepo.delete(p);
			List<ImageFile> list = ImageHandle.uploadImages(files);
			for (ImageFile imageFile : list) {
				imageFile.setProduct(product);
			}
			product.setImageFiles(list);
			product.setSubCategory(subCategory);
			product.setCategoryId(subCategory.getCategory().getId());
			productRepo.save(product);
		}

		return true;
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public boolean saveProduct(String subcatId, Product product, List<MultipartFile> files) throws Exception {
		SubCategory subCategory = subcatRepo.findById(subcatId).get();
		List<ImageFile> list = ImageHandle.uploadImages(files);
		for (ImageFile imageFile : list) {
			imageFile.setProduct(product);
		}
		product.setId(UUID.randomUUID().toString());
		product.setImageFiles(list);
		product.setSubCategory(subCategory);
		product.setCategoryId(subCategory.getCategory().getId());
		productRepo.save(product);
		return true;
	}

	@Override
	public List<Product> getAllProductBysubCategory(String id) {
		SubCategory subCategory = subcatRepo.findById(id).get();
		List<Product> list = productRepo.findBySubCategory(subCategory);
		return list;

	}

	@Override
	public List<Product> getAllProductBysubCategory() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Page<Product> getAllProductByCategory(String catId, int page) {
		Pageable pageRequest = PageRequest.of(page, 40);
		Page<Product> findByCId = productRepo.findByCategoryId(catId, pageRequest);

		return findByCId;
	}

	@Override
	public Page<Product> getAllProductByFeature(boolean b, int page) {
		Pageable pageRequest = PageRequest.of(page, 8);
		return productRepo.findByIsfeature(true, pageRequest);

	}

	@Override
	public Page<Product> getAllProductByPopular(boolean b, int page) {
		Pageable pageRequest = PageRequest.of(page, 8);
		return productRepo.findByIspopular(true, pageRequest);

	}

	@Override
	public Page<Product> getAllProductByOffer(boolean b, int page) {
		Pageable pageRequest = PageRequest.of(page, 8);
		return productRepo.findByIsoffer(true, pageRequest);

	}

	@Override
	public Page<Product> getAllProductByCategoryAndSubCategory(int page, String subcatId) {
		Pageable pageRequest = PageRequest.of(page, 40);

		Page<Product> bySubCategory = productRepo.findBySubCategoryId(subcatId, pageRequest);

		return bySubCategory;

	}

	@Override
	public Page<Product> getAllProductByFeature(int page) {
		Pageable pageRequest = PageRequest.of(page, 4);
		return productRepo.findByIsfeature(true, pageRequest);
	}

	@Override
	public Page<Product> getAllProductByPopular(int page) {
		Pageable pageRequest = PageRequest.of(page, 4);
		return productRepo.findByIspopular(true, pageRequest);
	}

	@Override
	public Page<Product> getAllProductByOffer(int page) {
		Pageable pageRequest = PageRequest.of(page, 4);
		return productRepo.findByIsoffer(true, pageRequest);
	}

	@Override
	public Page<Product> getAllProducts(int page, String catId, String subcatId) {
		Pageable pageRequest = PageRequest.of(page, 4);
		Page<Product> products = null;
		if (subcatId.equals("0")) {
			products = productRepo.findByCategoryId(catId, pageRequest);
		} else if (catId.equals("searching")) {
			products = productRepo.findByNameContaining(subcatId, pageRequest);
		} else if (catId.equals("sort") && subcatId.equals("AToZ")) {
			products = productRepo.findByOrderByNameAsc(pageRequest);
		} else if (catId.equals("sort") && subcatId.equals("ZToA")) {
			products = productRepo.findByOrderByNameDesc(pageRequest);
		} else if (catId.equals("sort") && subcatId.equals("LToH")) {
			products = productRepo.findByOrderByPriceAsc(pageRequest);
		} else if (catId.equals("sort") && subcatId.equals("HToL")) {
			products = productRepo.findByOrderByPriceDesc(pageRequest);
		} else if (catId.equals("product") && subcatId.equals("feature")) {
			products = productRepo.findByIsfeature(true, pageRequest);
		} else if (catId.equals("product") && subcatId.equals("popular")) {
			products = productRepo.findByIspopular(true, pageRequest);
		} else if (catId.equals("product") && subcatId.equals("offer")) {
			products = productRepo.findByIsoffer(true, pageRequest);
		} else {
			products = productRepo.findBySubCategoryId(subcatId, pageRequest);
		}
		return products;
	}

}
