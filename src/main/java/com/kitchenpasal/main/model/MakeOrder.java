package com.kitchenpasal.main.model;

public class MakeOrder {
	private Cart carts;
	private double subTotal;
	private double deliveryCharge;
	private double vat;
	private double discount;
	private double grandTotal;
	
	
	public Cart getCarts() {
		return carts;
	}
	public void setCarts(Cart carts) {
		this.carts = carts;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
}
