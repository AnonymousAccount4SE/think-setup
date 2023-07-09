package com.mps.think.setup.vo;
import com.mps.think.setup.model.AddRenewals;

public class EffortRangeVO {
	
	private Integer id;
	private AddRenewals addRenewal;
	private Integer mru_ren_card_order_code_seq;
	private Integer effortFrom;
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
		return "EffortRangeVO [id=" + id + ", addRenewal=" + addRenewal + ", mru_ren_card_order_code_seq="
				+ mru_ren_card_order_code_seq + ", effortFrom=" + effortFrom + ", effortTo=" + effortTo + "]";
	}
	
	
	

}
