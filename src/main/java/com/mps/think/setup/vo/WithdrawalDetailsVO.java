package com.mps.think.setup.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.vo.EnumModelVO.Currency;

public class WithdrawalDetailsVO {

	private Integer id;

	private Date paymentDate;

	private String type;

	private Currency paymentCurrency;

	private BigDecimal paymentAmount;

	private BigDecimal paymentBaseAmount;

	private Date orderDate;

	private Currency orderCurrency;

	private BigDecimal netLocalAmount;

	private BigDecimal netBaseAmount;

	private OrderVO orderId;

	private CustomerDetailsVO customer;
	
	private PublisherVO publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Currency getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(Currency paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public BigDecimal getPaymentBaseAmount() {
		return paymentBaseAmount;
	}

	public void setPaymentBaseAmount(BigDecimal paymentBaseAmount) {
		this.paymentBaseAmount = paymentBaseAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Currency getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(Currency orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	public BigDecimal getNetLocalAmount() {
		return netLocalAmount;
	}

	public void setNetLocalAmount(BigDecimal netLocalAmount) {
		this.netLocalAmount = netLocalAmount;
	}

	public BigDecimal getNetBaseAmount() {
		return netBaseAmount;
	}

	public void setNetBaseAmount(BigDecimal netBaseAmount) {
		this.netBaseAmount = netBaseAmount;
	}

	public OrderVO getOrderId() {
		return orderId;
	}

	public void setOrderId(OrderVO orderId) {
		this.orderId = orderId;
	}

	public PublisherVO getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherVO publisher) {
		this.publisher = publisher;
	}

	public CustomerDetailsVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetailsVO customer) {
		this.customer = customer;
	}
	
	
	
	

}
