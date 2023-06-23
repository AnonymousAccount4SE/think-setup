package com.mps.think.setup.vo;

import java.sql.Date;



import com.mps.think.setup.model.CancelReasons;
import com.mps.think.setup.model.Order;

public class CancelOrderVO {
	
    private Integer cancelorderId;
    private Order orderid;
	private Float refundamount;
	private CancelReasons CancelReasonsId;
	private Boolean donotrenew;
	private Boolean cancelactiveorder;
	private Boolean cancelentiresubscription;
	private String refundto;
	private String cardNumber;
	private String cardholdername;
	private Boolean renewanorder;
	private Boolean payanotherorder;
	private String paymentaccount;
	private String paymenttype;
	private String card;
	private Date date;
	private String nameoncard;
	private String ordersid;
	public Integer getCancelorderId() {
		return cancelorderId;
	}
	public void setCancelorderId(Integer cancelorderId) {
		this.cancelorderId = cancelorderId;
	}
	public Order getOrderid() {
		return orderid;
	}
	public void setOrderid(Order orderid) {
		this.orderid = orderid;
	}
	public Float getRefundamount() {
		return refundamount;
	}
	public void setRefundamount(Float refundamount) {
		this.refundamount = refundamount;
	}
	public CancelReasons getCancelReasonsId() {
		return CancelReasonsId;
	}
	public void setCancelReasonsId(CancelReasons cancelReasonsId) {
		CancelReasonsId = cancelReasonsId;
	}
	public Boolean getDonotrenew() {
		return donotrenew;
	}
	public void setDonotrenew(Boolean donotrenew) {
		this.donotrenew = donotrenew;
	}
	public Boolean getCancelactiveorder() {
		return cancelactiveorder;
	}
	public void setCancelactiveorder(Boolean cancelactiveorder) {
		this.cancelactiveorder = cancelactiveorder;
	}
	public Boolean getCancelentiresubscription() {
		return cancelentiresubscription;
	}
	public void setCancelentiresubscription(Boolean cancelentiresubscription) {
		this.cancelentiresubscription = cancelentiresubscription;
	}
	public String getRefundto() {
		return refundto;
	}
	public void setRefundto(String refundto) {
		this.refundto = refundto;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardholdername() {
		return cardholdername;
	}
	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}
	public Boolean getRenewanorder() {
		return renewanorder;
	}
	public void setRenewanorder(Boolean renewanorder) {
		this.renewanorder = renewanorder;
	}
	public Boolean getPayanotherorder() {
		return payanotherorder;
	}
	public void setPayanotherorder(Boolean payanotherorder) {
		this.payanotherorder = payanotherorder;
	}
	public String getPaymentaccount() {
		return paymentaccount;
	}
	public void setPaymentaccount(String paymentaccount) {
		this.paymentaccount = paymentaccount;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}
	public String getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}
	@Override
	public String toString() {
		return "CancelOrderVO [cancelorderId=" + cancelorderId + ", orderid=" + orderid + ", refundamount="
				+ refundamount + ", CancelReasonsId=" + CancelReasonsId + ", donotrenew=" + donotrenew
				+ ", cancelactiveorder=" + cancelactiveorder + ", cancelentiresubscription=" + cancelentiresubscription
				+ ", refundto=" + refundto + ", cardNumber=" + cardNumber + ", cardholdername=" + cardholdername
				+ ", renewanorder=" + renewanorder + ", payanotherorder=" + payanotherorder + ", paymentaccount="
				+ paymentaccount + ", paymenttype=" + paymenttype + ", card=" + card + ", date=" + date
				+ ", nameoncard=" + nameoncard + ", ordersid=" + ordersid + "]";
	}
	
	
	
	
	
}
