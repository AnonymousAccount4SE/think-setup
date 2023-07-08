package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class DayEndProcessVO {

	private Integer id;
	private Publisher pubId;
	private DayEndCustomerAddressUpdateVO customerAddressUpdate;
	private DayEndSusReinVO suspendOrReinstate;
	private DayEndOrderStatusUpdateVO orderStatusUpdate;
	private DayEndEmailQueueVO emailOrEventQueue;
	private DayEndInvoiceIdGenVO invoiceIdGen;
	private DayEndInternetDocRefUpdateVO internetDocRefUpdate;
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

	public DayEndCustomerAddressUpdateVO getCustomerAddressUpdate() {
		return customerAddressUpdate;
	}

	public void setCustomerAddressUpdate(DayEndCustomerAddressUpdateVO customerAddressUpdate) {
		this.customerAddressUpdate = customerAddressUpdate;
	}

	public DayEndSusReinVO getSuspendOrReinstate() {
		return suspendOrReinstate;
	}

	public void setSuspendOrReinstate(DayEndSusReinVO suspendOrReinstate) {
		this.suspendOrReinstate = suspendOrReinstate;
	}

	public DayEndOrderStatusUpdateVO getOrderStatusUpdate() {
		return orderStatusUpdate;
	}

	public void setOrderStatusUpdate(DayEndOrderStatusUpdateVO orderStatusUpdate) {
		this.orderStatusUpdate = orderStatusUpdate;
	}

	public DayEndEmailQueueVO getEmailOrEventQueue() {
		return emailOrEventQueue;
	}

	public void setEmailOrEventQueue(DayEndEmailQueueVO emailOrEventQueue) {
		this.emailOrEventQueue = emailOrEventQueue;
	}

	public DayEndInvoiceIdGenVO getInvoiceIdGen() {
		return invoiceIdGen;
	}

	public void setInvoiceIdGen(DayEndInvoiceIdGenVO invoiceIdGen) {
		this.invoiceIdGen = invoiceIdGen;
	}

	public DayEndInternetDocRefUpdateVO getInternetDocRefUpdate() {
		return internetDocRefUpdate;
	}

	public void setInternetDocRefUpdate(DayEndInternetDocRefUpdateVO internetDocRefUpdate) {
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
		return "DayEndProcessVO [id=" + id + ", pubId=" + pubId + ", customerAddressUpdate=" + customerAddressUpdate
				+ ", suspendOrReinstate=" + suspendOrReinstate + ", orderStatusUpdate=" + orderStatusUpdate
				+ ", emailOrEventQueue=" + emailOrEventQueue + ", invoiceIdGen=" + invoiceIdGen
				+ ", internetDocRefUpdate=" + internetDocRefUpdate + ", logging=" + logging + "]";
	}

}
