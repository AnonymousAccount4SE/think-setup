package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "source_Code")
@Entity
public class SourceCode extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1831986296356956427L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sourc_code_id")
	private Integer sourceCodeId;

	@ManyToOne
	@JoinColumn(name = "oc_id", referencedColumnName = "oc_id")
	private OrderClass ocId;

	@Column(name = "description")
	private String description;

	@Column(name = "order_code")
	private String orderCode;

	@Column(name = "order_code_type")
	private String order_code_type;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "state_break")
	private Boolean state_Break;

	@Column(name = "cost")
	private Integer cost;

	@Column(name = "is_generated")
	private Boolean isGenerated;

	@Column(name = "generic_agency")
	private Boolean generic_agency;

	@Column(name = "is_ddp")
	private Boolean is_ddp;

	@Column(name = "source_code")
	private String sourceCode;

	@Column(name = "source_code_type")
	private String sourceCodeType;
	
	@Column(name = "order_type")
	private String orderType;

	// These are dropdown fields ===============
	// @Column(name="source_code_format")
	// private String sourceCodeFormat;

	@ManyToOne
	@JoinColumn(name = "source_code_format_id", referencedColumnName = "id")
	private SourceFormat sourceCodeFormat;

	@ManyToOne
	@JoinColumn(name = "rate_card_id", referencedColumnName = "rcId")
	private RateCards rateCards;

	@ManyToOne
	@JoinColumn(name = "discount_id", referencedColumnName = "id")
	private DiscountCardKeyInfo discountCardKeyInfo;
	
	@ManyToOne
	@JoinColumn(name = "renewal_card_id", referencedColumnName = "id")
	private AddRenewals renewalCard;

	@ManyToOne
	@JoinColumn(name = "shipping_price_list_id", referencedColumnName = "id")
	private ShippingPriceList shippingPriceList;

	@OneToMany(
			mappedBy = "sourceCode",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<SourceCodeAndValuesMapping> sourceCodeAndValuesMappings;

	public Integer getSourceCodeId() {
		return sourceCodeId;
	}

	public void setSourceCodeId(Integer sourceCodeId) {
		this.sourceCodeId = sourceCodeId;
	}

	public OrderClass getOcId() {
		return ocId;
	}

	public void setOcId(OrderClass ocId) {
		this.ocId = ocId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrder_code_type() {
		return order_code_type;
	}

	public void setOrder_code_type(String order_code_type) {
		this.order_code_type = order_code_type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getState_Break() {
		return state_Break;
	}

	public void setState_Break(Boolean state_Break) {
		this.state_Break = state_Break;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Boolean getIsGenerated() {
		return isGenerated;
	}

	public void setIsGenerated(Boolean isGenerated) {
		this.isGenerated = isGenerated;
	}

	public Boolean getGeneric_agency() {
		return generic_agency;
	}

	public void setGeneric_agency(Boolean generic_agency) {
		this.generic_agency = generic_agency;
	}

	public Boolean getIs_ddp() {
		return is_ddp;
	}

	public void setIs_ddp(Boolean is_ddp) {
		this.is_ddp = is_ddp;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceCodeType() {
		return sourceCodeType;
	}

	public void setSourceCodeType(String sourceCodeType) {
		this.sourceCodeType = sourceCodeType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public SourceFormat getSourceCodeFormat() {
		return sourceCodeFormat;
	}

	public void setSourceCodeFormat(SourceFormat sourceCodeFormat) {
		this.sourceCodeFormat = sourceCodeFormat;
	}

	public RateCards getRateCards() {
		return rateCards;
	}

	public void setRateCards(RateCards rateCards) {
		this.rateCards = rateCards;
	}

	public DiscountCardKeyInfo getDiscountCardKeyInfo() {
		return discountCardKeyInfo;
	}

	public void setDiscountCardKeyInfo(DiscountCardKeyInfo discountCardKeyInfo) {
		this.discountCardKeyInfo = discountCardKeyInfo;
	}

	public AddRenewals getRenewalCard() {
		return renewalCard;
	}

	public void setRenewalCard(AddRenewals renewalCard) {
		this.renewalCard = renewalCard;
	}

	public ShippingPriceList getShippingPriceList() {
		return shippingPriceList;
	}

	public void setShippingPriceList(ShippingPriceList shippingPriceList) {
		this.shippingPriceList = shippingPriceList;
	}

	public List<SourceCodeAndValuesMapping> getSourceCodeAndValuesMappings() {
		return sourceCodeAndValuesMappings;
	}

	public void setSourceCodeAndValuesMappings(List<SourceCodeAndValuesMapping> sourceCodeAndValuesMappings) {
		this.sourceCodeAndValuesMappings = sourceCodeAndValuesMappings;
	}

	@Override
	public String toString() {
		return "SourceCode [sourceCodeId=" + sourceCodeId + ", ocId=" + ocId + ", description=" + description
				+ ", orderCode=" + orderCode + ", order_code_type=" + order_code_type + ", quantity=" + quantity
				+ ", isActive=" + isActive + ", state_Break=" + state_Break + ", cost=" + cost + ", isGenerated="
				+ isGenerated + ", generic_agency=" + generic_agency + ", is_ddp=" + is_ddp + ", sourceCode="
				+ sourceCode + ", sourceCodeType=" + sourceCodeType + ", orderType=" + orderType + ", sourceCodeFormat="
				+ sourceCodeFormat + ", rateCards=" + rateCards + ", discountCardKeyInfo=" + discountCardKeyInfo
				+ ", renewalCard=" + renewalCard + ", shippingPriceList=" + shippingPriceList
				+ ", sourceCodeAndValuesMappings=" + sourceCodeAndValuesMappings + "]";
	}

	

	
	
}
