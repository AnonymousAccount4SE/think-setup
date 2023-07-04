package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Order;

public class CustomerWithOrders {

	private CustomerDetails customer;
	
	private List<Order> customerOrders;

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

	@Override
	public String toString() {
		return "CustomerWithOrders [customer=" + customer + ", customerOrders=" + customerOrders + "]";
	}
	
}
