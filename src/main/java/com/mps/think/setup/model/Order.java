package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;


@Table(name = "order_parent")
@Entity
public class Order extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493733554330117672L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerDetails customerId;
	
	@ManyToOne
	@JoinColumn(name = "order_class_id", referencedColumnName = "oc_id")
	private OrderClass orderClass;
	
	@Column(name = "order_type")
	private String orderType;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "orderStatus")
//	private OrderStatus orderStatus;
	
	@Column(name= "order_status")
	private String orderStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "key_order_information_id", referencedColumnName = "id" )
	private OrderKeyInformation keyOrderInformation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_items_id", referencedColumnName = "id" )
	private OrderItems orderItemsAndTerms;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "payment_breakdown_id", referencedColumnName = "id" )
	private PaymentBreakdown paymentBreakdown;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "delivery_options_id", referencedColumnName = "id" )
	private OrderDeliveryOptions deliveryAndBillingOptions;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "order_address_id", referencedColumnName = "id" )
//	private OrderAddressMapping orderAddress;
	
	@OneToMany(
	        mappedBy = "order",
	        cascade = CascadeType.ALL
	    )
	@JsonManagedReference
	private List<OrderAddressMapping> orderAddresses;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "auxiliary_information_id", referencedColumnName = "id" )
	private OrderAuxiliaryInformation auxiliaryInformation;
	
	@ManyToOne
	@JoinColumn(name = "other_addresses_customer", referencedColumnName = "id")
	private CustomerDetails otherAddressCustomer;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonManagedReference
	private MultiLineItemOrder parentOrder;
	
	@Column(name = "old_order_id")
	private Integer oldOrderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public CustomerDetails getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerDetails customerId) {
		this.customerId = customerId;
	}

	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public OrderKeyInformation getKeyOrderInformation() {
		return keyOrderInformation;
	}

	public void setKeyOrderInformation(OrderKeyInformation keyOrderInformation) {
		this.keyOrderInformation = keyOrderInformation;
	}

	public OrderItems getOrderItemsAndTerms() {
		return orderItemsAndTerms;
	}

	public void setOrderItemsAndTerms(OrderItems orderItemsAndTerms) {
		this.orderItemsAndTerms = orderItemsAndTerms;
	}

	public PaymentBreakdown getPaymentBreakdown() {
		return paymentBreakdown;
	}

	public void setPaymentBreakdown(PaymentBreakdown paymentBreakdown) {
		this.paymentBreakdown = paymentBreakdown;
	}

	public OrderDeliveryOptions getDeliveryAndBillingOptions() {
		return deliveryAndBillingOptions;
	}

	public void setDeliveryAndBillingOptions(OrderDeliveryOptions deliveryAndBillingOptions) {
		this.deliveryAndBillingOptions = deliveryAndBillingOptions;
	}

	public List<OrderAddressMapping> getOrderAddresses() {
		return orderAddresses;
	}

	public void setOrderAddresses(List<OrderAddressMapping> orderAddresses) {
		this.orderAddresses = orderAddresses;
	}

	public OrderAuxiliaryInformation getAuxiliaryInformation() {
		return auxiliaryInformation;
	}

	public void setAuxiliaryInformation(OrderAuxiliaryInformation auxiliaryInformation) {
		this.auxiliaryInformation = auxiliaryInformation;
	}

	public CustomerDetails getOtherAddressCustomer() {
		return otherAddressCustomer;
	}

	public void setOtherAddressCustomer(CustomerDetails otherAddressCustomer) {
		this.otherAddressCustomer = otherAddressCustomer;
	}

	public MultiLineItemOrder getParentOrder() {
		return parentOrder;
	}

	public void setParentOrder(MultiLineItemOrder parentOrder) {
		this.parentOrder = parentOrder;

	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderClass=" + orderClass
				+ ", orderType=" + orderType + ", orderStatus=" + orderStatus + ", keyOrderInformation="
				+ keyOrderInformation + ", orderItemsAndTerms=" + orderItemsAndTerms + ", paymentBreakdown="
				+ paymentBreakdown + ", deliveryAndBillingOptions=" + deliveryAndBillingOptions + ", orderAddresses="
				+ orderAddresses + ", auxiliaryInformation=" + auxiliaryInformation + ", otherAddressCustomer="
				+ otherAddressCustomer + ", parentOrder=" + parentOrder + "]";
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOldOrderId() {
		return oldOrderId;
	}

	public void setOldOrderId(Integer oldOrderId) {
		this.oldOrderId = oldOrderId;
	}
	
}
