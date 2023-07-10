package com.mps.think.setup.vo;

import java.math.BigDecimal;
 


public class SalesByMonthView {

 private	 String  month;
 private	 String pubId;
 private     BigDecimal baseAmount;
 private	 String baseCurrency;
 private	 String subscriptionCategory;
 private	 String orderClass;
 private	 String orderCategory;
 private	 int Year;
 
 
public String getPubId() {
	return pubId;
}
public void setPubId(String pubId) {
	this.pubId = pubId;
}

public BigDecimal getBaseAmount() {
	return baseAmount;
}
public void setBaseAmount(BigDecimal baseAmount) {
	this.baseAmount = baseAmount;
}
public String getBaseCurrency() {
	return baseCurrency;
}
public void setBaseCurrency(String baseCurrency) {
	this.baseCurrency = baseCurrency;
}
public String getSubscriptionCategory() {
	return subscriptionCategory;
}
public void setSubscriptionCategory(String subscriptionCategory) {
	this.subscriptionCategory = subscriptionCategory;
}
public String getOrderClass() {
	return orderClass;
}
public void setOrderClass(String orderClass) {
	this.orderClass = orderClass;
}
public String getOrderCategory() {
	return orderCategory;
}
public void setOrderCategory(String orderCategory) {
	this.orderCategory = orderCategory;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public int getYear() {
	return Year;
}
public void setYear(int year) {
	Year = year;
}
 
 

	 
	 
	 
	 
	
	
}
