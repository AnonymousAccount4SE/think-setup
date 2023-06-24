package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "multi_line_item_order")
public class MultiLineItemOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Order order;
	
	@JoinColumn(name = "parent_order_id")
	private Integer parentOrderId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getParentOrderId() {
		return parentOrderId;
	}

	public void setParentOrderId(Integer parentOrderId) {
		this.parentOrderId = parentOrderId;
	}

	@Override
	public String toString() {
		return "MultiLineItemOrder [id=" + id + ", parentOrderId=" + parentOrderId + "]";
	}

	
	
}
