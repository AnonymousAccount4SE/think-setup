package com.mps.think.setup.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mps.think.setup.vo.EnumModelVO.Currency;
import com.stripe.model.Customer;

@Entity
@Table(name = "refund_deposite_details")
public class RefundDepositDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "payment_date")
	private Date paymentDate;

	@Column(name = "sequence")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sequence;

	@Column(name = "pay_type")
	private String payType;

	@Enumerated(EnumType.STRING)
	@Column(name = "currency")
	private Currency currency;

	@Column(name = "payment")
	private BigDecimal payment;

	@Column(name = "initial_deposit")
	private BigDecimal initialDeposit;
	
	@Column(name = "deposit_bal")
	private BigDecimal depositBal;
	
	@Column(name = "base_payment")
	private BigDecimal basePayment;
	
	@Column(name = "base_initial")
	private BigDecimal baseInitial;
	
	@Column(name = "base_deposit_bal")
	private BigDecimal baseDepositBal;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerDetails customer;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
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

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

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

	public BigDecimal getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(BigDecimal initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	public BigDecimal getDepositBal() {
		return depositBal;
	}

	public void setDepositBal(BigDecimal depositBal) {
		this.depositBal = depositBal;
	}

	public BigDecimal getBasePayment() {
		return basePayment;
	}

	public void setBasePayment(BigDecimal basePayment) {
		this.basePayment = basePayment;
	}

	public BigDecimal getBaseInitial() {
		return baseInitial;
	}

	public void setBaseInitial(BigDecimal baseInitial) {
		this.baseInitial = baseInitial;
	}

	public BigDecimal getBaseDepositBal() {
		return baseDepositBal;
	}

	public void setBaseDepositBal(BigDecimal baseDepositBal) {
		this.baseDepositBal = baseDepositBal;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}



}
