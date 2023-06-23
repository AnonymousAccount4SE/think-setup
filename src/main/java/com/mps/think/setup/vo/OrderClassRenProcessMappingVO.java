package com.mps.think.setup.vo;

import com.mps.think.setup.model.OrderClass;

public class OrderClassRenProcessMappingVO {

	private Integer id;
	private OrderClass orderClass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	@Override
	public String toString() {
		return "OrderClassRenProcessMappingVO [id=" + id + ", orderClass=" + orderClass + "]";
	}

}
