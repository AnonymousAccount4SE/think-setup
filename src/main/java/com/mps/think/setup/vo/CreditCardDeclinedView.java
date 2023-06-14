package com.mps.think.setup.vo;

import java.util.Date;

public class CreditCardDeclinedView {
	
	private Date paymentDate;
	
	private Integer orderId;
	
	private String creditCardNumber;
	
	private String creditCardExpiryDate;
	
	private double baseAmount;
	
	private String localAmount;
	
	private String nameOfCustomer;
	
	private Integer CustomerNumber;
	
	private String currency;

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardExpiryDate() {
		return creditCardExpiryDate;
	}

	public void setCreditCardExpiryDate(String creditCardExpiryDate) {
		this.creditCardExpiryDate = creditCardExpiryDate;
	}

	public double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public String getLocalAmount() {
		return localAmount;
	}

	public void setLocalAmount(String localAmount) {
		this.localAmount = localAmount;
	}

	public String getNameOfCustomer() {
		return nameOfCustomer;
	}

	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}

	public Integer getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		CustomerNumber = customerNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
}
