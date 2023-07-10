package com.mps.think.setup.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mps.think.setup.vo.EnumModelVO.SubDefStatus;

@Entity
@Table(name = "subscription_def_tbl")
public class SubscriptionDefKeyInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id")
	private Publisher publisher;
	
	@ManyToOne
	@JoinColumn(name = "order_class_id", referencedColumnName = "oc_id")
	private OrderClass orderClass; 
	
	@Column(name = "subs_def_code")
	private String subscriptionDefCode;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "order_code_id", referencedColumnName = "id")
	private OrderCodesSuper orderCode;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "subscription_terms_mapping_tbl",
			joinColumns = {@JoinColumn(name = "subscription_id", referencedColumnName = "id")},
		    inverseJoinColumns = {@JoinColumn(name = "term_id", referencedColumnName = "termsId")}
	)
	private List<Terms> terms;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "subs_def_status")
	private SubDefStatus subDefStatus;
	
	@Column(name = "subs_def_id")
	private String subDefId;
	
	@OneToOne
	@JoinColumn(name = "rate_card_id", referencedColumnName = "rcId")
	private RateCards rateCard;
	
//	@OneToOne
//	@JoinColumn(name = "renewal_card_id")
//	private RenewalCard renewalCard;
	
	@ManyToOne
	@JoinColumn(name = "renewal_card", referencedColumnName = "id")
	private AddRenewals renewalCard;
	
	@Column(name = "order_code_type")
	private String orderCodeType;
	
	@Column(name = "media")
	private String media;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "category")
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
		return "SubscriptionDefKeyInfo [id=" + id + ", publisher=" + publisher + ", orderClass=" + orderClass
				+ ", subscriptionDefCode=" + subscriptionDefCode + ", description=" + description + ", orderCode="
				+ orderCode + ", terms=" + terms + ", subDefStatus=" + subDefStatus + ", subDefId=" + subDefId
				+ ", rateCard=" + rateCard + ", renewalCard=" + renewalCard + ", orderCodeType=" + orderCodeType
				+ ", media=" + media + ", edition=" + edition + ", category=" + category + "]";
	}

	

	

}
