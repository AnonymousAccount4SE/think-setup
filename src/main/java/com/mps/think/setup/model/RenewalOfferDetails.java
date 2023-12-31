package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "ren_offer_detail")
@Entity
public class RenewalOfferDetails extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "renewal_offer_details_id")
	private Integer renewalOfferDetailsId;
	
	@ManyToOne
	@JoinColumn(name = "effort_range_id", referencedColumnName = "id")
	private EffortRange effortRange;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "oclass_id" , referencedColumnName = "oc_id")
	private OrderClass oclass;
	
	@ManyToOne
	@JoinColumn(name = "term_id" , referencedColumnName = "termsId")
	private Terms term;
	
	@ManyToOne
	@JoinColumn(name = "order_code_id", referencedColumnName = "id")
	private OrderCodesSuper order_code;
	
	@ManyToOne
	@JoinColumn(name = "source_code_id", referencedColumnName = "sourc_code_id")
	private SourceCode source_code;
	
	@ManyToOne
	@JoinColumn(name = "subscription_def_id", referencedColumnName = "id")
	private SubscriptionDefKeyInfo subscription_def;
	
//	need to change integer to renewalOffer class name and join column with pkg_def_id
	@Column(name = "pkg_def_id")
	private Integer pkg_def_id;
	
	@ManyToOne
	@JoinColumn(name = "rate_class_id", referencedColumnName = "rcId")
	private RateCards rate_class;

	@ManyToOne
	@JoinColumn(name = "discount_class_id", referencedColumnName = "id")
	private DiscountCardKeyInfo discount_class;

	public Integer getRenewalOfferDetailsId() {
		return renewalOfferDetailsId;
	}

	public void setRenewalOfferDetailsId(Integer renewalOfferDetailsId) {
		this.renewalOfferDetailsId = renewalOfferDetailsId;
	}

	public EffortRange getEffortRange() {
		return effortRange;
	}

	public void setEffortRange(EffortRange effortRange) {
		this.effortRange = effortRange;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderClass getOclass() {
		return oclass;
	}

	public void setOclass(OrderClass oclass) {
		this.oclass = oclass;
	}

	public Terms getTerm() {
		return term;
	}

	public void setTerm(Terms term) {
		this.term = term;
	}

	public OrderCodesSuper getOrder_code() {
		return order_code;
	}

	public void setOrder_code(OrderCodesSuper order_code) {
		this.order_code = order_code;
	}

	public SourceCode getSource_code() {
		return source_code;
	}

	public void setSource_code(SourceCode source_code) {
		this.source_code = source_code;
	}

	public SubscriptionDefKeyInfo getSubscription_def() {
		return subscription_def;
	}

	public void setSubscription_def(SubscriptionDefKeyInfo subscription_def) {
		this.subscription_def = subscription_def;
	}

	public Integer getPkg_def_id() {
		return pkg_def_id;
	}

	public void setPkg_def_id(Integer pkg_def_id) {
		this.pkg_def_id = pkg_def_id;
	}

	public RateCards getRate_class() {
		return rate_class;
	}

	public void setRate_class(RateCards rate_class) {
		this.rate_class = rate_class;
	}

	public DiscountCardKeyInfo getDiscount_class() {
		return discount_class;
	}

	public void setDiscount_class(DiscountCardKeyInfo discount_class) {
		this.discount_class = discount_class;
	}

	@Override
	public String toString() {
		return "RenewalOfferDetails [renewalOfferDetailsId=" + renewalOfferDetailsId + ", effortRange=" + effortRange
				+ ", description=" + description + ", oclass=" + oclass + ", term=" + term + ", order_code="
				+ order_code + ", source_code=" + source_code + ", subscription_def=" + subscription_def
				+ ", pkg_def_id=" + pkg_def_id + ", rate_class=" + rate_class + ", discount_class=" + discount_class
				+ "]";
	}

}
