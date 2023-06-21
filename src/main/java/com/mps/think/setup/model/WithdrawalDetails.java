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
import javax.persistence.Table;

import com.mps.think.setup.vo.EnumModelVO.Currency;

@Entity
@Table(name = "withdrawal_details")
public class WithdrawalDetails extends BaseEntity {

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
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "payment_currency")
	private Currency paymentCurrency;
	
	@Column(name = "payment_amount")
	private BigDecimal paymentAmount;
	
	@Column(name = "payment_base_amount")
	private BigDecimal paymentBaseAmount;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_currency")
	private Currency orderCurrency;
	
	@Column(name = "net_local_amount")
	private BigDecimal netLocalAmount;
	
	@Column(name = "net_base_amount")
	private BigDecimal netBaseAmount;
	
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private Order orderId;
	
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

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
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
