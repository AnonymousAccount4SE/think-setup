package com.mps.think.setup.vo;

import java.util.Date;

public class DailyCreditCardAndPaymentReportView {
	
	private Integer orderNumber;
	
	private Date paymentDate;
	
	private Integer customerNumber;
	
	private String nameOfCustomer;
	
	private Date orderDate;
	
	private Integer bundleQuantity;
	
	private String currency;
	
	private double paymentAmount;
	
	private double paymentBaseAmount;

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getNameOfCustomer() {
		return nameOfCustomer;
	}

	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getBundleQuantity() {
		return bundleQuantity;
	}

	public void setBundleQuantity(Integer bundleQuantity) {
		this.bundleQuantity = bundleQuantity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getPaymentBaseAmount() {
		return paymentBaseAmount;
	}

	public void setPaymentBaseAmount(double paymentBaseAmount) {
		this.paymentBaseAmount = paymentBaseAmount;
	}

	
}
