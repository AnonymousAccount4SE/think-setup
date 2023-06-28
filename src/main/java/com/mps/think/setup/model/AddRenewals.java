package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "add_renewals")
public class AddRenewals extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;
	
	@ManyToOne
	@JoinColumn(name = "oclass_id" , referencedColumnName = "oc_id")
	private OrderClass oclass;

	@Column(name = "description")
	private String description;

	@Column(name = "renewal_card")
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

	public OrderClass getOclass() {
		return oclass;
	}

	public void setOclass(OrderClass oclass) {
		this.oclass = oclass;
	}

	@Override
	public String toString() {
		return "AddRenewals [id=" + id + ", pubId=" + pubId + ", oclass=" + oclass + ", description=" + description
				+ ", renewal_card=" + renewal_card + "]";
	}



}
