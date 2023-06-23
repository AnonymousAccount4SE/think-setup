package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.Nth;
import com.mps.think.setup.model.RenewalCard;
import com.mps.think.setup.model.VolumeGroup;

public class AddProcessRenewalsVO {

	private Integer id;

	private Boolean renewalForRequalification;
	private Boolean generateAutoRenewalOffers;
	private Boolean generateNoticesforPackageMembers;
	private Boolean renewTo;
	private Boolean renDef;
	private Boolean currency;
	private Boolean ordClass;
	private Boolean orderNumber;
	private RenewalCard renewalCard;
	private Nth nthDefinition;
	private VolumeGroup volumeGroup;
	private List<RenewalDefinitionProcessMappingVO> renewalDefinitionProcessMapping;
	private List<OrderClassRenProcessMappingVO> orderClassRenProcessMapping;
	private List<EffortsRenProcessMappingVO> effortsRenProcessMapping;

	public RenewalCard getRenewalCard() {
		return renewalCard;
	}

	public void setRenewalCard(RenewalCard renewalCard) {
		this.renewalCard = renewalCard;
	}

	public Nth getNthDefinition() {
		return nthDefinition;
	}

	public void setNthDefinition(Nth nthDefinition) {
		this.nthDefinition = nthDefinition;
	}

	public VolumeGroup getVolumeGroup() {
		return volumeGroup;
	}

	public void setVolumeGroup(VolumeGroup volumeGroup) {
		this.volumeGroup = volumeGroup;
	}

	public List<RenewalDefinitionProcessMappingVO> getRenewalDefinitionProcessMapping() {
		return renewalDefinitionProcessMapping;
	}

	public void setRenewalDefinitionProcessMapping(
			List<RenewalDefinitionProcessMappingVO> renewalDefinitionProcessMapping) {
		this.renewalDefinitionProcessMapping = renewalDefinitionProcessMapping;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getRenewalForRequalification() {
		return renewalForRequalification;
	}

	public void setRenewalForRequalification(Boolean renewalForRequalification) {
		this.renewalForRequalification = renewalForRequalification;
	}

	public Boolean getGenerateAutoRenewalOffers() {
		return generateAutoRenewalOffers;
	}

	public void setGenerateAutoRenewalOffers(Boolean generateAutoRenewalOffers) {
		this.generateAutoRenewalOffers = generateAutoRenewalOffers;
	}

	public Boolean getGenerateNoticesforPackageMembers() {
		return generateNoticesforPackageMembers;
	}

	public void setGenerateNoticesforPackageMembers(Boolean generateNoticesforPackageMembers) {
		this.generateNoticesforPackageMembers = generateNoticesforPackageMembers;
	}

	public Boolean getRenewTo() {
		return renewTo;
	}

	public void setRenewTo(Boolean renewTo) {
		this.renewTo = renewTo;
	}

	public Boolean getCurrency() {
		return currency;
	}

	public void setCurrency(Boolean currency) {
		this.currency = currency;
	}

	public Boolean getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Boolean orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Boolean getRenDef() {
		return renDef;
	}

	public void setRenDef(Boolean renDef) {
		this.renDef = renDef;
	}

	public Boolean getOrdClass() {
		return ordClass;
	}

	public void setOrdClass(Boolean ordClass) {
		this.ordClass = ordClass;
	}

	public List<OrderClassRenProcessMappingVO> getOrderClassRenProcessMapping() {
		return orderClassRenProcessMapping;
	}

	public void setOrderClassRenProcessMapping(List<OrderClassRenProcessMappingVO> orderClassRenProcessMapping) {
		this.orderClassRenProcessMapping = orderClassRenProcessMapping;
	}

	public List<EffortsRenProcessMappingVO> getEffortsRenProcessMapping() {
		return effortsRenProcessMapping;
	}

	public void setEffortsRenProcessMapping(List<EffortsRenProcessMappingVO> effortsRenProcessMapping) {
		this.effortsRenProcessMapping = effortsRenProcessMapping;
	}

	@Override
	public String toString() {
		return "AddProcessRenewalsVO [id=" + id + ", renewalForRequalification=" + renewalForRequalification
				+ ", generateAutoRenewalOffers=" + generateAutoRenewalOffers + ", generateNoticesforPackageMembers="
				+ generateNoticesforPackageMembers + ", renewTo=" + renewTo + ", renDef=" + renDef + ", currency="
				+ currency + ", ordClass=" + ordClass + ", orderNumber=" + orderNumber + ", renewalCard=" + renewalCard
				+ ", nthDefinition=" + nthDefinition + ", volumeGroup=" + volumeGroup
				+ ", renewalDefinitionProcessMapping=" + renewalDefinitionProcessMapping
				+ ", orderClassRenProcessMapping=" + orderClassRenProcessMapping + ", effortsRenProcessMapping="
				+ effortsRenProcessMapping + "]";
	}

}
