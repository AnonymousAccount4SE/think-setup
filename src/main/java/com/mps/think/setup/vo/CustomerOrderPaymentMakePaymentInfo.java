package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.MakePayment;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.PaymentInformation;

public class CustomerOrderPaymentMakePaymentInfo {

	private List<CustomerSolrVO> customer;
	
	private List<OrderSolrVO> orders;
	
	private List<PaymentInfoSolrVO> paymentInfos;
	
	private List<MakePaymentSolrVO> paymentAccounts;

	public List<CustomerSolrVO> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CustomerSolrVO> customer) {
		this.customer = customer;
	}

	public List<OrderSolrVO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderSolrVO> orders) {
		this.orders = orders;
	}

	public List<PaymentInfoSolrVO> getPaymentInfos() {
		return paymentInfos;
	}

	public void setPaymentInfos(List<PaymentInfoSolrVO> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

	public List<MakePaymentSolrVO> getPaymentAccounts() {
		return paymentAccounts;
	}

	public void setPaymentAccounts(List<MakePaymentSolrVO> paymentAccounts) {
		this.paymentAccounts = paymentAccounts;
	}

	@Override
	public String toString() {
		return "CustomerOrderPaymentMakePaymentInfo [customer=" + customer + ", orders=" + orders + ", paymentInfos="
				+ paymentInfos + ", paymentAccounts=" + paymentAccounts + "]";
	}



	
}
