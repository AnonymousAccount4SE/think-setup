package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.MakePayment;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.PaymentInformation;

public class CustomerWithOrders {

	private CustomerDetails customer;
	
	private List<Order> customerOrders;
	
	private List<PaymentInformation> customerPaymentInfo;
	
	private List<MakePayment> customerPaymentAccount;

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	public List<Order> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<Order> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public List<PaymentInformation> getCustomerPaymentInfo() {
		return customerPaymentInfo;
	}

	public void setCustomerPaymentInfo(List<PaymentInformation> customerPaymentInfo) {
		this.customerPaymentInfo = customerPaymentInfo;
	}

	public List<MakePayment> getCustomerPaymentAccount() {
		return customerPaymentAccount;
	}

	public void setCustomerPaymentAccount(List<MakePayment> customerPaymentAccount) {
		this.customerPaymentAccount = customerPaymentAccount;
	}

	@Override
	public String toString() {
		return "CustomerWithOrders [customer=" + customer + ", customerOrders=" + customerOrders
				+ ", customerPaymentInfo=" + customerPaymentInfo + ", customerPaymentAccount=" + customerPaymentAccount
				+ "]";
	}
	
	

	
}
