package com.kitchenpasal.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kitchenpasal.main.model.Category;
import com.kitchenpasal.main.model.Product;
import com.kitchenpasal.main.model.SliderItems;
import com.kitchenpasal.main.model.SubCategory;
import com.kitchenpasal.main.service.CategoryService;
import com.kitchenpasal.main.service.ProductService;
import com.kitchenpasal.main.service.SliderItemsService;
import com.kitchenpasal.main.service.SubCategoryService;

@Controller
@RequestMapping("/myadmin")
public class AdminSaveController {
	@Autowired
	private CategoryService catService;
	@Autowired
	private SubCategoryService subcatService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SliderItemsService itemservice;

	// save category
	@PostMapping("/saveCategory")
	public String savingCategory(@ModelAttribute("cat") Category category, HttpSession session) {
		try {
			catService.saveCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/myadmin/viewcategory";
	}

	// modify or update category
	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute("cat") Category category, HttpSession session) {
		try {
			catService.updateCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/myadmin/viewcategory";
	}

	// save sub category
	@PostMapping("/saveSubCategory")
	public String saveSubCategory(@RequestParam("catId") String catId,
			@ModelAttribute("subcat") SubCategory subCategory, HttpSession session) {
		try {
			subcatService.saveCategory(catId, subCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/myadmin/viewsubcategory/" + catId;
	}

	// modify or update sub category
	@PostMapping("/updateSubCategory")
	public String updateSubCategory(@RequestParam("cId") String catId,
			@ModelAttribute("subcat") SubCategory subCategory, HttpSession session) {

		try {
			subcatService.updateCategory(catId, subCategory);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/myadmin/viewsubcategory/" + catId;
	}

	// save product
	@PostMapping("/saveProduct")
	public String savingProduct(@RequestParam("subcatId") String subcatId,
			@RequestParam("pictures") List<MultipartFile> files, @ModelAttribute("product") Product product,
			HttpSession session) {
		try {
			productService.saveProduct(subcatId, product, files);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/myadmin/viewproduct/" + subcatId;
	}

	// save product
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestParam("subcatId") String subcatId,
			@RequestParam("pictures") List<MultipartFile> files, @ModelAttribute("product") Product product,
			HttpSession session) {
		productService.updateProduct(subcatId, product, files);

		return "redirect:/myadmin/viewproduct/" + subcatId;
	}
	// save saveSliderImage
	@PostMapping("/saveSliderImage")
	public String saveSlider(@RequestParam("sImg") MultipartFile files, @ModelAttribute("si") SliderItems items,
			HttpSession session) {
		System.out.println(items.getName());
		System.out.println(files.getOriginalFilename());
		itemservice.save(items, files);
		return "redirect:/myadmin/viewsliderimages";
	}
}
