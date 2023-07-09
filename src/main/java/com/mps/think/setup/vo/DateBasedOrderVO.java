package com.mps.think.setup.vo;

import java.util.List;

public class DateBasedOrderVO {
	
	private Integer orderId;
	
	private CustomerDetailsVO customerId;
	
	private OrderClassVO orderClass;
	
//	private OrderStatus orderStatus;
	
	private OrderKeyInformationVO keyOrderInformation;
	
	private DateBasedItemsAndTermVO orderItemsAndTerms;
	
	private PaymentBreakdownVO paymentBreakdown;
	
	private OrderDeliveryOptionsVO deliveryAndBillingOptions;
	
	private List<OrderAddressMappingVO> orderAddresses;
	
	private OrderAuxiliaryInformationVO auxiliaryInformation;
	
	private CustomerDetailsVO otherAddressCustomer;
	
	private MultiLineItemOrderVO parentOrder;
	
	private Integer oldOrderId;
	
	private CommodityCodesVO commodityCodes;
	
//	private Boolean isRenewed;

	public Integer getOldOrderId() {
		return oldOrderId;
	}

	public void setOldOrderId(Integer oldOrderId) {
		this.oldOrderId = oldOrderId;
	}

	public CommodityCodesVO getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodesVO commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public CustomerDetailsVO getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerDetailsVO customerId) {
		this.customerId = customerId;
	}

	public OrderClassVO getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClassVO orderClass) {
		this.orderClass = orderClass;
	}

	public OrderKeyInformationVO getKeyOrderInformation() {
		return keyOrderInformation;
	}

	public void setKeyOrderInformation(OrderKeyInformationVO keyOrderInformation) {
		this.keyOrderInformation = keyOrderInformation;
	}

	public DateBasedItemsAndTermVO getOrderItemsAndTerms() {
		return orderItemsAndTerms;
	}

	public void setOrderItemsAndTerms(DateBasedItemsAndTermVO orderItemsAndTerms) {
		this.orderItemsAndTerms = orderItemsAndTerms;
	}

	public PaymentBreakdownVO getPaymentBreakdown() {
		return paymentBreakdown;
	}

	public void setPaymentBreakdown(PaymentBreakdownVO paymentBreakdown) {
		this.paymentBreakdown = paymentBreakdown;
	}

	public OrderDeliveryOptionsVO getDeliveryAndBillingOptions() {
		return deliveryAndBillingOptions;
	}

	public void setDeliveryAndBillingOptions(OrderDeliveryOptionsVO deliveryAndBillingOptions) {
		this.deliveryAndBillingOptions = deliveryAndBillingOptions;
	}

	public List<OrderAddressMappingVO> getOrderAddresses() {
		return orderAddresses;
	}

	public void setOrderAddresses(List<OrderAddressMappingVO> orderAddresses) {
		this.orderAddresses = orderAddresses;
	}

	public OrderAuxiliaryInformationVO getAuxiliaryInformation() {
		return auxiliaryInformation;
	}

	public void setAuxiliaryInformation(OrderAuxiliaryInformationVO auxiliaryInformation) {
		this.auxiliaryInformation = auxiliaryInformation;
	}

	public CustomerDetailsVO getOtherAddressCustomer() {
		return otherAddressCustomer;
	}

	public void setOtherAddressCustomer(CustomerDetailsVO otherAddressCustomer) {
		this.otherAddressCustomer = otherAddressCustomer;
	}

	public MultiLineItemOrderVO getParentOrder() {
		return parentOrder;
	}

	public void setParentOrder(MultiLineItemOrderVO parentOrder) {
		this.parentOrder = parentOrder;
	}

	
}
