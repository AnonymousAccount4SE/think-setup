package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "effort_range")
public class EffortRange extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "add_renewal", referencedColumnName = "id")
	private AddRenewals addRenewal;
	
	@Column(name = "mru_ren_card_order_code_seq")
	private Integer mru_ren_card_order_code_seq;
	
	@Column(name = "effortFrom")
	private Integer effortFrom;
	
	@Column(name = "effortTo")
	private Integer effortTo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AddRenewals getAddRenewal() {
		return addRenewal;
	}

	public void setAddRenewal(AddRenewals addRenewal) {
		this.addRenewal = addRenewal;
	}

	public Integer getMru_ren_card_order_code_seq() {
		return mru_ren_card_order_code_seq;
	}

	public void setMru_ren_card_order_code_seq(Integer mru_ren_card_order_code_seq) {
		this.mru_ren_card_order_code_seq = mru_ren_card_order_code_seq;
	}

	public Integer getEffortFrom() {
		return effortFrom;
	}

	public void setEffortFrom(Integer effortFrom) {
		this.effortFrom = effortFrom;
	}

	public Integer getEffortTo() {
		return effortTo;
	}

	public void setEffortTo(Integer effortTo) {
		this.effortTo = effortTo;
	}

	@Override
	public String toString() {
		return "EffortRange [id=" + id + ", addRenewal=" + addRenewal + ", mru_ren_card_order_code_seq="
				+ mru_ren_card_order_code_seq + ", effortFrom=" + effortFrom + ", effortTo=" + effortTo + "]";
	}

	
	
	

}
