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
@Table(name = "efforts_ren_process_mapping")
public class EffortsRenProcessMapping extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "efforts", referencedColumnName = "id")
	private AddEffort efforts;
	
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

	public AddEffort getEffort() {
		return efforts;
	}

	public void setEffort(AddEffort efforts) {
		this.efforts = efforts;
	}

	public AddProcessRenewals getAddProcessRenewals() {
		return addProcessRenewals;
	}

	public void setAddProcessRenewals(AddProcessRenewals addProcessRenewals) {
		this.addProcessRenewals = addProcessRenewals;
	}

	@Override
	public String toString() {
		return "EffortsRenProcessMapping [id=" + id + ", efforts=" + efforts + ", addProcessRenewals="
				+ addProcessRenewals + "]";
	}

}
