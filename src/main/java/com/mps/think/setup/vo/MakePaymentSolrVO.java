package com.mps.think.setup.vo;

import java.util.LinkedHashMap;

import com.mps.think.setup.model.Publisher;

public class MakePaymentSolrVO {
	
	private Integer id;
	private String nameOfCustomer;
	private String payerCustomer;
	private double totalAmount;
	private long paymentAccount;
	private String paymentType;
	private String card;
//	private double amountToBePaid;
	private String expiryDate;
	private String transactionStatus;
	private String chargeId;
	private String status;
	private double totalPaidAmount;
//	private Publisher publisher;
	private LinkedHashMap<Integer, Double> listOfOrder;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameOfCustomer() {
		return nameOfCustomer;
	}
	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}
	public String getPayerCustomer() {
		return payerCustomer;
	}
	public void setPayerCustomer(String payerCustomer) {
		this.payerCustomer = payerCustomer;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public long getPaymentAccount() {
		return paymentAccount;
	}
	public void setPaymentAccount(long paymentAccount) {
		this.paymentAccount = paymentAccount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalPaidAmount() {
		return totalPaidAmount;
	}
	public void setTotalPaidAmount(double totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}
	public LinkedHashMap<Integer, Double> getListOfOrder() {
		return listOfOrder;
	}
	public void setListOfOrder(LinkedHashMap<Integer, Double> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}
	@Override
	public String toString() {
		return "MakePaymentSolrVO [id=" + id + ", nameOfCustomer=" + nameOfCustomer + ", payerCustomer=" + payerCustomer
				+ ", totalAmount=" + totalAmount + ", paymentAccount=" + paymentAccount + ", paymentType=" + paymentType
				+ ", card=" + card + ", expiryDate=" + expiryDate + ", transactionStatus=" + transactionStatus
				+ ", chargeId=" + chargeId + ", status=" + status + ", totalPaidAmount=" + totalPaidAmount
				+ ", listOfOrder=" + listOfOrder + "]";
	}
	

}
