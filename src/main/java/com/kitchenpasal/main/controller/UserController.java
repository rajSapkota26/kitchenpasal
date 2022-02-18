package com.kitchenpasal.main.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kitchenpasal.main.model.MakeOrder;
import com.kitchenpasal.main.model.Order;
import com.kitchenpasal.main.service.CartService;
import com.kitchenpasal.main.service.CategoryService;
import com.kitchenpasal.main.service.OrderService;
import com.kitchenpasal.main.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private CategoryService catService;
	@Autowired
	CartService cartService;
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;

	@GetMapping("/addToCart/{pId}/{quantity}")
	public String addmyCartPage(@PathVariable("pId") String pId, @PathVariable("quantity") Integer quantity,
			Model model, Principal principal) {		
		try {
			cartService.saveCart(principal.getName(), pId, quantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/user/mycart";
	}

	@GetMapping("/mycart")
	public String myCartPage(Model model, Principal principal) {
		model.addAttribute("carts", cartService.getAllCartByUserId(principal.getName()));
		return "user/mycart";
	}
	@GetMapping("/myorder")
	public String myordersPage(Model model, Principal principal) {
		model.addAttribute("orders", orderService.getAllOrdersByUser(principal.getName()));
		return "user/myorders";
	}
	@GetMapping("/userdashboard")
	public String userdashboardPage(Model model, Principal principal) {
		model.addAttribute("user", userService.findbyUserName(principal.getName()));
		return "user/userdashboard";
	}

	@GetMapping("/placeOrder/{id}")
	public String checkout(@PathVariable("id") String pId, Model model, Principal principal,HttpSession session) {

		MakeOrder makeOrder = cartService.getMakeOrder(pId, principal.getName(),session);
		model.addAttribute("preOder",makeOrder);
		model.addAttribute("order",new Order());

		return "user/checkout";
	}
	@GetMapping("/createOrder/{id}")
	public String checkoutbycart(@PathVariable("id") String cartId, Model model, Principal principal) {
		
		MakeOrder makeOrder = cartService.getMakeOrderforCart(cartId, principal.getName());
		model.addAttribute("preOder",makeOrder);
		model.addAttribute("order",new Order());
		
		return "user/checkout";
	}

	@GetMapping("/deletecart/{id}")
	public String deletecart(@PathVariable("id") String cartId) {
		cartService.deleteCart(cartId);
		return "redirect:/user/mycart";
	}
	@PostMapping("/submitOrder")
	public String submitOrder(@ModelAttribute("order")Order order,Principal principal) {
		orderService.saveOrder(order, principal.getName());
		return "redirect:/user/myorder";
	}

	// common part for all handler
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {

		model.addAttribute("userName", 	principal.getName());
		model.addAttribute("cat", catService.getAllCategory());
		model.addAttribute("title", "Kitchen pasal");
	}
}
