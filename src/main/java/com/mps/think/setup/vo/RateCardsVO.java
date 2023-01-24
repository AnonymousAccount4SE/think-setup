package com.mps.think.setup.vo;



import com.mps.think.setup.model.ParentClass;


public class RateCardsVO {
	
    private Integer rcId;
    private ParentClass parentId;
	private Integer rateClassEffectiveSequence;
	private Integer rateClassId;
	private String rateCard;
	private String description;
//	private String orderClasses;
	private String itemtype;
	private Boolean useForPackage;
	private Float defaultPricePerItem;
	public Integer getRcId() {
		return rcId;
	}
	public void setRcId(Integer rcId) {
		this.rcId = rcId;
	}
	public ParentClass getParentId() {
		return parentId;
	}
	public void setParentId(ParentClass parentId) {
		this.parentId = parentId;
	}
	public Integer getRateClassEffectiveSequence() {
		return rateClassEffectiveSequence;
	}
	public void setRateClassEffectiveSequence(Integer rateClassEffectiveSequence) {
		this.rateClassEffectiveSequence = rateClassEffectiveSequence;
	}
	public Integer getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(Integer rateClassId) {
		this.rateClassId = rateClassId;
	}
	public String getRateCard() {
		return rateCard;
	}
	public void setRateCard(String rateCard) {
		this.rateCard = rateCard;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public Boolean getUseForPackage() {
		return useForPackage;
	}
	public void setUseForPackage(Boolean useForPackage) {
		this.useForPackage = useForPackage;
	}
	public Float getDefaultPricePerItem() {
		return defaultPricePerItem;
	}
	public void setDefaultPricePerItem(Float defaultPricePerItem) {
		this.defaultPricePerItem = defaultPricePerItem;
	}
	@Override
	public String toString() {
		return "RateCardsVO [rcId=" + rcId + ", parentId=" + parentId + ", rateClassEffectiveSequence="
				+ rateClassEffectiveSequence + ", rateClassId=" + rateClassId + ", rateCard=" + rateCard
				+ ", description=" + description + ", itemtype=" + itemtype + ", useForPackage=" + useForPackage
				+ ", defaultPricePerItem=" + defaultPricePerItem + "]";
	}
	
	
	
	
	
	
}
