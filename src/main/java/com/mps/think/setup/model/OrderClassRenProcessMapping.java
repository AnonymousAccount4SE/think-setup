package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_class_ren_process_mappping")
public class OrderClassRenProcessMapping extends BaseEntity {

	private static final long serialVersionUID = -2896231971485236016L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_class", referencedColumnName = "oc_id")
	private OrderClass orderClass;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "add_process_renewals", referencedColumnName = "id")
	private AddProcessRenewals addProcessRenewals;

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

	public AddProcessRenewals getAddProcessRenewals() {
		return addProcessRenewals;
	}

	public void setAddProcessRenewals(AddProcessRenewals addProcessRenewals) {
		this.addProcessRenewals = addProcessRenewals;
	}

	@Override
	public String toString() {
		return "OrderClassRenProcessMapping [id=" + id + ", orderClass=" + orderClass + ", addProcessRenewals="
				+ addProcessRenewals + "]";
	}

}
