package com.mps.think.setup.vo;


import java.util.List;

import com.mps.think.setup.model.AddRenewals;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.Terms;
import com.mps.think.setup.vo.EnumModelVO.SubDefStatus;

public class SubscriptionDefKeyInfoVO {

	private Integer id;
  
	private Publisher publisher;

	private OrderClass orderClass;

	private String subscriptionDefCode;

	private String description;

	private OrderCodesSuper orderCode;

	private List<Terms> terms;

	private SubDefStatus subDefStatus;

	private String subDefId;

	private RateCards rateCard;

//	private RenewalCard renewalCard;
	
	private AddRenewals renewalCard;

	private String orderCodeType;

	private String media;

	private String edition;

	private String category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public OrderClass getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}

	public String getSubscriptionDefCode() {
		return subscriptionDefCode;
	}

	public void setSubscriptionDefCode(String subscriptionDefCode) {
		this.subscriptionDefCode = subscriptionDefCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderCodesSuper getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(OrderCodesSuper orderCode) {
		this.orderCode = orderCode;
	}

	public List<Terms> getTerms() {
		return terms;
	}

	public void setTerms(List<Terms> terms) {
		this.terms = terms;
	}

	public SubDefStatus getSubDefStatus() {
		return subDefStatus;
	}

	public void setSubDefStatus(SubDefStatus subDefStatus) {
		this.subDefStatus = subDefStatus;
	}

	public String getSubDefId() {
		return subDefId;
	}

	public void setSubDefId(String subDefId) {
		this.subDefId = subDefId;
	}

	public RateCards getRateCard() {
		return rateCard;
	}

	public void setRateCard(RateCards rateCard) {
		this.rateCard = rateCard;
	}

	public AddRenewals getRenewalCard() {
		return renewalCard;
	}

	public void setRenewalCard(AddRenewals renewalCard) {
		this.renewalCard = renewalCard;
	}

	public String getOrderCodeType() {
		return orderCodeType;
	}

	public void setOrderCodeType(String orderCodeType) {
		this.orderCodeType = orderCodeType;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubscriptionDefKeyInfoVO [id=" + id + ", publisher=" + publisher + ", orderClass=" + orderClass
				+ ", subscriptionDefCode=" + subscriptionDefCode + ", description=" + description + ", orderCode="
				+ orderCode + ", terms=" + terms + ", subDefStatus=" + subDefStatus + ", subDefId=" + subDefId
				+ ", rateCard=" + rateCard + ", renewalCard=" + renewalCard + ", orderCodeType=" + orderCodeType
				+ ", media=" + media + ", edition=" + edition + ", category=" + category + "]";
	}

	

	
}
