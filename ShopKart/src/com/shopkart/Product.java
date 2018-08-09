package com.shopkart;

public class Product {
	String productId,productName,category;
	int price,quantity,discountPerc;
	int taxRate;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String productId, String productName, String category, int price, int quantity, int discountPerc,
			int taxRate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.discountPerc = discountPerc;
		this.taxRate = taxRate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscountPerc() {
		return discountPerc;
	}
	public void setDiscountPerc(int discountPerc) {
		this.discountPerc = discountPerc;
	}
	public int getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}
	
	
}
