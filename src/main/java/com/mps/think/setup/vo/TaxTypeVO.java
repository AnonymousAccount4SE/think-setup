package com.mps.think.setup.vo;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mps.think.setup.model.CommodityCodes;

public class TaxTypeVO {

	private Integer taxId;

	private PublisherVO pubId;

	private String taxType;

	private String description;
	
	private CommodityCodesVO commodityCodesVO;

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public PublisherVO getPubId() {
		return pubId;
	}

	public void setPubId(PublisherVO pubId) {
		this.pubId = pubId;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommodityCodesVO getCommodityCodesVO() {
		return commodityCodesVO;
	}

	public void setCommodityCodesVO(CommodityCodesVO commodityCodesVO) {
		this.commodityCodesVO = commodityCodesVO;
	}

	@Override
	public String toString() {
		return "TaxTypeVO [taxId=" + taxId + ", pubId=" + pubId + ", taxType=" + taxType + ", description="
				+ description + ", commodityCodesVO=" + commodityCodesVO + "]";
	}

}
