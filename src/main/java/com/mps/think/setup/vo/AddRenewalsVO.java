package com.mps.think.setup.vo;



import com.mps.think.setup.model.Publisher;

public class AddRenewalsVO {
	
	private Integer id;
	private Publisher pubId;
	private String description;
	private String renewal_card;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Publisher getPubId() {
		return pubId;
	}
	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRenewal_card() {
		return renewal_card;
	}
	public void setRenewal_card(String renewal_card) {
		this.renewal_card = renewal_card;
	}
	@Override
	public String toString() {
		return "AddRenewalsVO [id=" + id + ", pubId=" + pubId + ", description=" + description + ", renewal_card="
				+ renewal_card + "]";
	}
	
	

}
