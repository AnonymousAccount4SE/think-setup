package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "add_process_renewals")
public class AddProcessRenewals extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "renewal_for_requalification")
	private Boolean renewalForRequalification;

	@Column(name = "generate_auto_renewal_offers")
	private Boolean generateAutoRenewalOffers;

	@Column(name = "generate_notices_for_package_members")
	private Boolean generateNoticesforPackageMembers;

	@Column(name = "renew_to")
	private Boolean renewTo;

	@Column(name = "ren_def")
	private Boolean renDef;

	@Column(name = "currency")
	private Boolean currency;

	@Column(name = "ord_class")
	private Boolean ordClass;

	@Column(name = "order_number")
	private Boolean orderNumber;

	@OneToOne
	@JoinColumn(name = "renewal_card_id")
	private RenewalCard renewalCard;

	@OneToOne
	@JoinColumn(name = "nthid")
	private Nth nthDefinition;

	@OneToOne
	@JoinColumn(name = "volume_group_id")
	private VolumeGroup volumeGroup;

	@OneToMany(mappedBy = "addProcessRenewals", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RenewalDefinitionProcessMapping> renewalDefinitionProcessMapping;

	@OneToMany(mappedBy = "addProcessRenewals", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrderClassRenProcessMapping> orderClassRenProcessMapping;

	@OneToMany(mappedBy = "addProcessRenewals", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<EffortsRenProcessMapping> effortsRenProcessMapping;

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

	public Boolean getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Boolean orderNumber) {
		this.orderNumber = orderNumber;
	}

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

	public List<RenewalDefinitionProcessMapping> getRenewalDefinitionProcessMapping() {
		return renewalDefinitionProcessMapping;
	}

	public void setRenewalDefinitionProcessMapping(
			List<RenewalDefinitionProcessMapping> renewalDefinitionProcessMapping) {
		this.renewalDefinitionProcessMapping = renewalDefinitionProcessMapping;
	}

	public List<OrderClassRenProcessMapping> getOrderClassRenProcessMapping() {
		return orderClassRenProcessMapping;
	}

	public void setOrderClassRenProcessMapping(List<OrderClassRenProcessMapping> orderClassRenProcessMapping) {
		this.orderClassRenProcessMapping = orderClassRenProcessMapping;
	}

	public List<EffortsRenProcessMapping> getEffortsRenProcessMapping() {
		return effortsRenProcessMapping;
	}

	public void setEffortsRenProcessMapping(List<EffortsRenProcessMapping> effortsRenProcessMapping) {
		this.effortsRenProcessMapping = effortsRenProcessMapping;
	}

	@Override
	public String toString() {
		return "AddProcessRenewals [id=" + id + ", renewalForRequalification=" + renewalForRequalification
				+ ", generateAutoRenewalOffers=" + generateAutoRenewalOffers + ", generateNoticesforPackageMembers="
				+ generateNoticesforPackageMembers + ", renewTo=" + renewTo + ", renDef=" + renDef + ", currency="
				+ currency + ", ordClass=" + ordClass + ", orderNumber=" + orderNumber + ", renewalCard=" + renewalCard
				+ ", nthDefinition=" + nthDefinition + ", volumeGroup=" + volumeGroup
				+ ", renewalDefinitionProcessMapping=" + renewalDefinitionProcessMapping
				+ ", orderClassRenProcessMapping=" + orderClassRenProcessMapping + ", effortsRenProcessMapping="
				+ effortsRenProcessMapping + "]";
	}

}
