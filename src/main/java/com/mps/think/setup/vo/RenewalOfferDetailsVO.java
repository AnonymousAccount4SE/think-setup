package com.mps.think.setup.vo;

import com.mps.think.setup.model.AddRenewals;
import com.mps.think.setup.model.DiscountCardKeyInfo;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.SourceCode;
import com.mps.think.setup.model.SubscriptionDefKeyInfo;
import com.mps.think.setup.model.Terms;

public class RenewalOfferDetailsVO {

	private Integer renewalOfferDetailsId;
	private AddRenewals addRenewal;
	private String description;
	private OrderClass oclass;
	private Terms term;
	private OrderCodesSuperVO order_code;
	private SourceCode source_code;
	private SubscriptionDefKeyInfo subscription_def;
	private Integer pkg_def_id;
	private RateCards rate_class;
	private DiscountCardKeyInfo discount_class;
	
	public Integer getRenewalOfferDetailsId() {
		return renewalOfferDetailsId;
	}
	public void setRenewalOfferDetailsId(Integer renewalOfferDetailsId) {
		this.renewalOfferDetailsId = renewalOfferDetailsId;
	}
	public AddRenewals getAddRenewal() {
		return addRenewal;
	}
	public void setAddRenewal(AddRenewals addRenewal) {
		this.addRenewal = addRenewal;
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
	public OrderCodesSuperVO getOrder_code() {
		return order_code;
	}
	public void setOrder_code(OrderCodesSuperVO order_code) {
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

	
	
	

	

}
