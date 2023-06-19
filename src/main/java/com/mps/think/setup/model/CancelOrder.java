package com.mps.think.setup.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "cancel_order")
public class CancelOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cancel_order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cancelorderId;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "orderid" , referencedColumnName = "order_id" )
	private Order orderid;
	
	@Column(name = "refund_amount")
	private Float refundamount;
	
	@OneToOne
	@JoinColumn(name = "cancelReasons_Id", referencedColumnName = "cancelReasonsId" )
	private CancelReasons CancelReasonsId;
	
	@Column(name = "donotrenew")
	private Boolean donotrenew;
	
	@Column(name = "cancelactiveorder")
	private Boolean cancelactiveorder;
	
	@Column(name = "cancelentiresubscription")
	private Boolean cancelentiresubscription;
	
	@Column(name = "refundto")
	private String refundto;
	
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "card_holder_name")
	private String cardholdername;
	
	@Column(name = "renewanorder")
	private Boolean renewanorder;
	
	@Column(name = "payanotherorder")
	private Boolean payanotherorder;
	
	@Pattern(regexp="(^[0-9]*$)")
	@Column(name = "paymentaccount")
	private String paymentaccount;
	
	@Column(name = "paymenttype")
	private String paymenttype;
	
	@Pattern(regexp="(^[0-9]*$)")
	@Column(name = "card")
	private String card;
	
//	@DateTimeFormat(pattern = "MM/yyyy")
	@Column(name = "date")
	private Date date;
	
	@Column(name = "nameoncard")
	private String nameoncard;

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

	
	
	
	
}
