package com.shopkart;

public class Transaction {
	String productId;
	int quantity, distcountAmt, netAmt;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String productId, int quantity, int distcountAmt, int netAmt) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.distcountAmt = distcountAmt;
		this.netAmt = netAmt;
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

	public int getDistcountAmt() {
		return distcountAmt;
	}

	public void setDistcountAmt(int distcountAmt) {
		this.distcountAmt = distcountAmt;
	}

	public int getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(int netAmt) {
		this.netAmt = netAmt;
	}

}
