package com.kitchenpasal.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kitchenpasal.main.model.Category;
import com.kitchenpasal.main.model.Product;
import com.kitchenpasal.main.model.SubCategory;
import com.kitchenpasal.main.service.CategoryService;
import com.kitchenpasal.main.service.OrderService;
import com.kitchenpasal.main.service.ProductService;
import com.kitchenpasal.main.service.SubCategoryService;

@Controller
@RequestMapping("/myadmin")
public class AdminController {
	@Autowired
	private CategoryService catService;
	@Autowired
	private SubCategoryService subcatService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;

	// load home page
	@GetMapping("/index")
	public String adminHomePage() {
		return "admin/index";
	}

	// view category
	@GetMapping("/viewcategory")
	public String viewCategoryPage(Model model, HttpSession session) {
		model.addAttribute("allCat", catService.getAllCategory());
		model.addAttribute("cat", new Category());
		return "admin/viewCategory";
	}

	// view Sub category list by category id
	@GetMapping("/viewsubcategory/{id}")
	public String viewSubCategoryPage(@PathVariable("id") String catId, Model model, HttpSession session) {
		model.addAttribute("allSubCat", subcatService.getAllSubCategoryByCategory(catId));
		model.addAttribute("subcat", new SubCategory());
		model.addAttribute("cat", catService.getCategoryById(catId));
		return "admin/viewSubCategory";
	}

	// view orders
	@GetMapping("/vieworders")
	public String viewOrdersPage(Model model) {
		model.addAttribute("orders",orderService.getAllOrders());
		return "admin/viewOrders";
	}

	// view product page sub category wise
	@GetMapping("/viewproduct/{id}")
	public String viewProductPage(@PathVariable("id") String subcatId, Model model, HttpSession session) {
		model.addAttribute("subcatId", subcatService.getSubCategoryById(subcatId));
		model.addAttribute("allProduct", productService.getAllProductBysubCategory(subcatId));

		return "admin/viewProduct";
	}

	// view Slider
	@GetMapping("/viewsliderimages")
	public String viewSliderImagesPage() {
		return "admin/viewSliderImages";
	}

	
	
	
	// view Single order
	@GetMapping("/singleOrder/{oId}")
	public String singleorderDetails(@PathVariable("oId")String oId,Model model) {
		model.addAttribute("order",orderService.getOrderOrderById(oId));
		
		return "admin/singleorderDetails";
	}
	
	
	
	
	// delete category

	@GetMapping("/deletCategory/{id}")
	public String deletCategoryPage(@PathVariable("id") String catId) {
		catService.deleteCategory(catId);
		return "redirect:/myadmin/viewcategory";
	}

	// edit page category
	@GetMapping("/editCategory/{id}")
	public String editCategoryPage(@PathVariable("id") String catId, Model model) {
		model.addAttribute("cat", catService.getCategoryById(catId));

		return "admin/editCategory";
	}

	// delete sub category

	@GetMapping("/deletSubCategory/{id}")
	public String deletSubCategoryPage(@PathVariable("id") String subcatId) {
		subcatService.deleteCategory(subcatId);
		return "redirect:/myadmin/viewcategory";
	}

	// edit page sub category
	@GetMapping("/editsubCategory/{id}/{catId}")
	public String editsubCategory(@PathVariable("id") String catsubId, @PathVariable("catId") String catId,
			Model model) {
		model.addAttribute("subcat", subcatService.getSubCategoryById(catsubId));
		model.addAttribute("catId", catId);

		return "admin/editsubCategory";
	}

	// edit page Product
	@GetMapping("/editProduct/{id}/{subcatId}")
	public String editProduct(@PathVariable("id") String pId, @PathVariable("subcatId") String subcatId, Model model) {
		model.addAttribute("product", productService.getProductById(pId));
		model.addAttribute("subcatId", subcatService.getSubCategoryById(subcatId));

		return "admin/editProduct";
	}

	// add new product page
	@GetMapping("/addProduct/{id}")
	public String addProductPage(@PathVariable("id") String subcatId, Model model, HttpSession session) {
		model.addAttribute("subcatId", subcatService.getSubCategoryById(subcatId));
		model.addAttribute("product", new Product());
		return "admin/addProduct";
	}

	// delete category

	@GetMapping("/deletProduct/{id}/{subCatid}")
	public String deletProductPage(@PathVariable("id") String id, @PathVariable("subCatid") String subcatId) {
		productService.deleteProduct(id);
		return "redirect:/myadmin/viewproduct/" + subcatId;
	}

}
