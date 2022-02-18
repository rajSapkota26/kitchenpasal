package com.kitchenpasal.main.serviceImpl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitchenpasal.main.model.Cart;
import com.kitchenpasal.main.model.MakeOrder;
import com.kitchenpasal.main.model.Product;
import com.kitchenpasal.main.repository.CartRepository;
import com.kitchenpasal.main.repository.ProductRepository;
import com.kitchenpasal.main.repository.UserRepository;
import com.kitchenpasal.main.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	ProductRepository proRepo;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	UserRepository userRepo;

	@Override
	public void deleteCart(String cartId) {
		cartRepo.deleteById(cartId);

	}

	@Override
	public List<Cart> getAllCartByUserId(String userId) {
		// TODO Auto-generated method stub
		return cartRepo.findByUserId(userId);
	}

	@Override
	public void saveCart(String username, String pId, int qnty) throws Exception {
		Product product = proRepo.findById(pId).get();

		Cart localcart = cartRepo.findByProductIdAndUserId(pId, username);

		if (localcart != null) {
			qnty = qnty + localcart.getQuantity();
			localcart.setQuantity(qnty);
			localcart.setPrice(localcart.getPrice() * qnty);
			localcart.setMrp(localcart.getMrp() * qnty);
			localcart.setDiscount(localcart.getDiscount() * qnty);
			cartRepo.save(localcart);
		} else {
			Cart cart = new Cart();
			cart.setId(UUID.randomUUID().toString());
			cart.setUserId(username);
			cart.setProductId(pId);
			cart.setProductName(product.getName());
			cart.setProductImage(product.getImageFiles().get(0).getName());
			cart.setQuantity(qnty);
			cart.setPrice(product.getPrice());
			cart.setMrp(product.getMrpPrice());
			if (product.getMrpPrice() > product.getPrice()) {
				cart.setDiscount(product.getMrpPrice() - product.getPrice());
			} else {
				cart.setDiscount(0);
			}
			cartRepo.save(cart);
		}

	}

	@Override
	public MakeOrder getMakeOrder(String id, String userId,HttpSession session) {
		double price = 0;
		double discount = 0;
		double subtotal = 0;
		double deliverycharge = 0;
		double vat = 0.0;
		Product product = proRepo.findById(id).get();
		Cart cart = new Cart();
		cart.setId(UUID.randomUUID().toString());
		cart.setUserId(userId);
		cart.setProductId(product.getId());
		cart.setProductName(product.getName());
		cart.setProductImage(product.getImageFiles().get(0).getName());
		cart.setQuantity(1);
		cart.setPrice(product.getPrice());
		cart.setMrp(product.getMrpPrice());
		if (product.getMrpPrice() > product.getPrice()) {
			cart.setDiscount(product.getMrpPrice() - product.getPrice());
		} else {
			cart.setDiscount(0);
		}
		
		subtotal = product.getPrice();
		discount = cart.getDiscount();
		vat = (cart.getPrice() * 13) / 100;
		deliverycharge = 150;
		price = subtotal - discount + vat + deliverycharge;
		session.setAttribute("pCart", cart);
		MakeOrder makeOrder = new MakeOrder();
		makeOrder.setCarts(cart);
		makeOrder.setDeliveryCharge(deliverycharge);
		makeOrder.setSubTotal(subtotal);
		makeOrder.setVat(vat);
		makeOrder.setGrandTotal(price);
		makeOrder.setDiscount(discount);

		return makeOrder;
	}

	@Override
	public MakeOrder getMakeOrderforCart(String cartid, String userId) {
		Cart cart = cartRepo.findById(cartid).get();
		double subtotal = cart.getPrice();
		double discount = cart.getDiscount();
		double deliverycharge = 150;
		double vat = (subtotal * 13) / 100;
		double price = subtotal - discount + vat + deliverycharge;
		MakeOrder makeOrder = new MakeOrder();
		makeOrder.setCarts(cart);
		makeOrder.setDeliveryCharge(deliverycharge);
		makeOrder.setSubTotal(subtotal);
		makeOrder.setVat(vat);
		makeOrder.setGrandTotal(price);
		makeOrder.setDiscount(discount);
		return makeOrder;
	}

}
