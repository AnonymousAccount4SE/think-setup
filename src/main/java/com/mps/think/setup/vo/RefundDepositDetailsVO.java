package com.mps.think.setup.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.vo.EnumModelVO.Currency;

public class RefundDepositDetailsVO {

	private Integer id;

	private Date paymentDate;

//	private Integer sequence;

	private String payType;

	private Currency currency;

	private BigDecimal payment;

//	private BigDecimal initialDeposit;
	
//	private BigDecimal depositBal;
	
	private BigDecimal basePayment;
	
//	private BigDecimal baseInitial;
	
//	private BigDecimal baseDepositBal;
	
	private CustomerDetailsVO customer;
	
	private Publisher publisher;

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

//	public Integer getSequence() {
//		return sequence;
//	}
//
//	public void setSequence(Integer sequence) {
//		this.sequence = sequence;
//	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

//	public BigDecimal getInitialDeposit() {
//		return initialDeposit;
//	}
//
//	public void setInitialDeposit(BigDecimal initialDeposit) {
//		this.initialDeposit = initialDeposit;
//	}
//
//	public BigDecimal getDepositBal() {
//		return depositBal;
//	}
//
//	public void setDepositBal(BigDecimal depositBal) {
//		this.depositBal = depositBal;
//	}

	public BigDecimal getBasePayment() {
		return basePayment;
	}

	public void setBasePayment(BigDecimal basePayment) {
		this.basePayment = basePayment;
	}

//	public BigDecimal getBaseInitial() {
//		return baseInitial;
//	}
//
//	public void setBaseInitial(BigDecimal baseInitial) {
//		this.baseInitial = baseInitial;
//	}
//
//	public BigDecimal getBaseDepositBal() {
//		return baseDepositBal;
//	}
//
//	public void setBaseDepositBal(BigDecimal baseDepositBal) {
//		this.baseDepositBal = baseDepositBal;
//	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public CustomerDetailsVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetailsVO customer) {
		this.customer = customer;
	}
	
	
	
}
