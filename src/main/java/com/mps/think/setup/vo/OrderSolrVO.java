package com.mps.think.setup.vo;

import java.util.List;

public class OrderSolrVO {

	private Integer orderId;
	
//	private CustomerDetailsVO customerId;
	
	private OrderClassVO orderClass;
	
	private String orderType;
	
	private String orderStatus;
	
	private OrderKeyInformationVO keyOrderInformation;
	
	private OrderItemsVO orderItemsAndTerms;
	
	private PaymentBreakdownVO paymentBreakdown;
		
	private OrderDeliveryOptionsVO deliveryAndBillingOptions;
	
	private List<OrderAddressMappingVO> orderAddresses;
	
	private OrderAuxiliaryInformationVO auxiliaryInformation;
	
//	private CustomerDetailsVO otherAddressCustomer;
	
//	private MultiLineItemOrderVO parentOrder;
	
	private Integer oldOrderId;
	
	private CommodityCodesVO commodityCodes;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public OrderClassVO getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClassVO orderClass) {
		this.orderClass = orderClass;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderKeyInformationVO getKeyOrderInformation() {
		return keyOrderInformation;
	}

	public void setKeyOrderInformation(OrderKeyInformationVO keyOrderInformation) {
		this.keyOrderInformation = keyOrderInformation;
	}

	public OrderItemsVO getOrderItemsAndTerms() {
		return orderItemsAndTerms;
	}

	public void setOrderItemsAndTerms(OrderItemsVO orderItemsAndTerms) {
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

	@Override
	public String toString() {
		return "OrderSolrVO [orderId=" + orderId + ", orderClass=" + orderClass + ", orderType=" + orderType
				+ ", orderStatus=" + orderStatus + ", keyOrderInformation=" + keyOrderInformation
				+ ", orderItemsAndTerms=" + orderItemsAndTerms + ", paymentBreakdown=" + paymentBreakdown
				+ ", deliveryAndBillingOptions=" + deliveryAndBillingOptions + ", orderAddresses=" + orderAddresses
				+ ", auxiliaryInformation=" + auxiliaryInformation + ", oldOrderId=" + oldOrderId + ", commodityCodes="
				+ commodityCodes + "]";
	}
	
	
}
