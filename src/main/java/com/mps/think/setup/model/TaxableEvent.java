package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "taxable_event")
@Entity
public class TaxableEvent extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1232748709650176114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taxable_event_id")
	private Integer taxableEventId;

	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;

	@Column(name = "event_date")
	private String eventDate;	

	@Column(name = "event_type")
	private String eventType;
	
	@OneToOne
	@JoinColumn(name = "commodity_codes_id", referencedColumnName = "id")
	private CommodityCodes commodityCodes;

	public Integer getTaxableEventId() {
		return taxableEventId;
	}

	public void setTaxableEventId(Integer taxableEventId) {
		this.taxableEventId = taxableEventId;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

	@Override
	public String toString() {
		return "TaxableEvent [taxableEventId=" + taxableEventId + ", pubId=" + pubId + ", eventDate=" + eventDate
				+ ", eventType=" + eventType + ", commodityCodes=" + commodityCodes + "]";
	}

}
