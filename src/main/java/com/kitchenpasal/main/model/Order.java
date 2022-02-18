package com.kitchenpasal.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "productOrder")
public class Order {
	@Id
	private String id;
	private String username;
	private double subTotal;
	private double deliveryCharge;
	private double vat;
	private double discount;;
	private double payableAmount;
	private double transferAmount;
	private String deliveryAddress;
	private String phoneNumber;
	private String transactionCode;
	private String transactionId;	
	private String productId;	
	private String paymentgateway;	
	@Transient
	private Product product;
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	private Date submitDate;
	
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", username=" + username + ", subTotal=" + subTotal + ", deliveryCharge="
				+ deliveryCharge + ", vat=" + vat + ", discount=" + discount + ", payableAmount=" + payableAmount
				+ ", transferAmount=" + transferAmount + ", deliveryAddress=" + deliveryAddress + ", phoneNumber="
				+ phoneNumber + ", transactionCode=" + transactionCode + ", transactionId=" + transactionId
				+ ", productId=" + productId + ", quantity=" + quantity + ", submitDate=" + submitDate + ", status="
				+ status + "]";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getPaymentgateway() {
		return paymentgateway;
	}
	public void setPaymentgateway(String paymentgateway) {
		this.paymentgateway = paymentgateway;
	}
	
	
	

}
