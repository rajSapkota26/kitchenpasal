package com.kitchenpasal.main.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitchenpasal.main.model.Product;
import com.kitchenpasal.main.model.User;
import com.kitchenpasal.main.service.CategoryService;
import com.kitchenpasal.main.service.ProductService;
import com.kitchenpasal.main.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private ProductService productService;

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("allProduct", productService.getAllProductBysubCategory());
		model.addAttribute("fp", productService.getAllProductByFeature(false, 0));
		model.addAttribute("pp", productService.getAllProductByPopular(false, 0));
		model.addAttribute("op", productService.getAllProductByOffer(false, 0));
		return "index";
	}

	@GetMapping("/categorywiseproduct/{page}/{id}/{subcatId}")
	public String categorywiseproductPage(@PathVariable("page") int page, @PathVariable("id") String id,
			@PathVariable("subcatId") String sId, Model model) {

		if (sId.equals("0") || sId.length()>7) {
			model.addAttribute("cat1", catService.getCategoryById(id));
		}
		Page<Product> allProduct = productService.getAllProducts(page, id, sId);
		model.addAttribute("allProduct", allProduct);
		model.addAttribute("currentPage", page);
		model.addAttribute("catId", id);
		model.addAttribute("subcatId", sId);
		model.addAttribute("totalPage", allProduct.getTotalPages());
		return "categorywiseproduct";
	}

	
	

	@GetMapping("/productDetails/{id}")
	public String productDetailsPage(@PathVariable("id") String id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "product_details";
	}

	@GetMapping("/register")
	public String createAccountPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@GetMapping("/login")
	public String loginAccountPage(Model model) {
		return "login";
	}
	@GetMapping("/contact")
	public String contactus(Model model) {
		return "contactus";
	}
	@GetMapping("/about")
	public String aboutus(Model model) {
		return "aboutus";
	}
	@GetMapping("/policy")
	public String privacypolicy(Model model) {
		return "privacypolict";
	}

	@PostMapping("/do_register")
	public String createAccount(@ModelAttribute("user") User user,
			@RequestParam(value = "agreed", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {
		try {
			if (!agreement) {
				return "register";
			}
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "login";

	}
	@PostMapping("/searchingItems")
	public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
		
//		
		Page<Product> allProduct = productService.getAllProducts(0, "searching", keyword);
		model.addAttribute("allProduct", allProduct);
		model.addAttribute("currentPage", 0);
		model.addAttribute("catId", "searching");
		model.addAttribute("subcatId", keyword);
		model.addAttribute("totalPage", allProduct.getTotalPages());
		return "categorywiseproduct";
		
	}

	// common part for all handler
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = null;
		try {
			userName=principal.getName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("cat", catService.getAllCategory());
		model.addAttribute("title", "Kitchen pasal");
		model.addAttribute("userName", userName);

	}
}
