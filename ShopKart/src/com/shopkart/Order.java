package com.shopkart;

public class Order {
	String orderId, orderDate, customerName, paymentMethod;
	int grossTotal, tax, discount, netTotal;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String orderId, String orderDate, String customerName, String paymentMethod, int grossTotal, int tax,
			int discount, int netTotal) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.paymentMethod = paymentMethod;
		this.grossTotal = grossTotal;
		this.tax = tax;
		this.discount = discount;
		this.netTotal = netTotal;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(int grossTotal) {
		this.grossTotal = grossTotal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(int netTotal) {
		this.netTotal = netTotal;
	}

}
