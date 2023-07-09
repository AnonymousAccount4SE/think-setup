package com.mps.think.setup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "day_end_process")
public class DayEndProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customer_address_update", referencedColumnName = "id")
	private DayEndCustomerAddressUpdate customerAddressUpdate;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "suspend_reinstate", referencedColumnName = "id")
	private DayEndSusRein suspendOrReinstate;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_status_update", referencedColumnName = "id")
	private DayEndOrderStatusUpdate orderStatusUpdate;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "email_event_queue", referencedColumnName = "id")
	private DayEndEmailQueue emailOrEventQueue;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "invoice_id_gen", referencedColumnName = "id")
	private DayEndInvoiceIdGen invoiceIdGen;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "internet_doc_ref_update", referencedColumnName = "id")
	private DayEndInternetDocRefUpdate internetDocRefUpdate;

	@Column(name = "logging")
	private String logging;

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

	public DayEndCustomerAddressUpdate getCustomerAddressUpdate() {
		return customerAddressUpdate;
	}

	public void setCustomerAddressUpdate(DayEndCustomerAddressUpdate customerAddressUpdate) {
		this.customerAddressUpdate = customerAddressUpdate;
	}

	public DayEndSusRein getSuspendOrReinstate() {
		return suspendOrReinstate;
	}

	public void setSuspendOrReinstate(DayEndSusRein suspendOrReinstate) {
		this.suspendOrReinstate = suspendOrReinstate;
	}

	public DayEndOrderStatusUpdate getOrderStatusUpdate() {
		return orderStatusUpdate;
	}

	public void setOrderStatusUpdate(DayEndOrderStatusUpdate orderStatusUpdate) {
		this.orderStatusUpdate = orderStatusUpdate;
	}

	public DayEndEmailQueue getEmailOrEventQueue() {
		return emailOrEventQueue;
	}

	public void setEmailOrEventQueue(DayEndEmailQueue emailOrEventQueue) {
		this.emailOrEventQueue = emailOrEventQueue;
	}

	public DayEndInvoiceIdGen getInvoiceIdGen() {
		return invoiceIdGen;
	}

	public void setInvoiceIdGen(DayEndInvoiceIdGen invoiceIdGen) {
		this.invoiceIdGen = invoiceIdGen;
	}

	public DayEndInternetDocRefUpdate getInternetDocRefUpdate() {
		return internetDocRefUpdate;
	}

	public void setInternetDocRefUpdate(DayEndInternetDocRefUpdate internetDocRefUpdate) {
		this.internetDocRefUpdate = internetDocRefUpdate;
	}

	public String getLogging() {
		return logging;
	}

	public void setLogging(String logging) {
		this.logging = logging;
	}

	@Override
	public String toString() {
		return "DayEndProcess [id=" + id + ", pubId=" + pubId + ", customerAddressUpdate=" + customerAddressUpdate
				+ ", suspendOrReinstate=" + suspendOrReinstate + ", orderStatusUpdate=" + orderStatusUpdate
				+ ", emailOrEventQueue=" + emailOrEventQueue + ", invoiceIdGen=" + invoiceIdGen
				+ ", internetDocRefUpdate=" + internetDocRefUpdate + ", logging=" + logging + "]";
	}
	
	
}
