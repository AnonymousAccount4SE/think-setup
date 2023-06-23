package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Publisher;

public class AddPaymentVO {
	private Integer id;
	private String typeOfPaymentAccount;
	private boolean selectCreditCard;
	private boolean selectCreditCardWithToken;
	private String creditCard;
	private int cvc;
	private String token;
	private String creditCardLastDigit;
	private String cardType;
	private String nameOfCardHolder;
	private Date  validFrom;
	private Date  validTo;
	private CustomerDetails customerDetails;
	private Publisher publisher;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeOfPaymentAccount() {
		return typeOfPaymentAccount;
	}
	public void setTypeOfPaymentAccount(String typeOfPaymentAccount) {
		this.typeOfPaymentAccount = typeOfPaymentAccount;
	}
	public boolean isSelectCreditCard() {
		return selectCreditCard;
	}
	public void setSelectCreditCard(boolean selectCreditCard) {
		this.selectCreditCard = selectCreditCard;
	}
	public boolean isSelectCreditCardWithToken() {
		return selectCreditCardWithToken;
	}
	public void setSelectCreditCardWithToken(boolean selectCreditCardWithToken) {
		this.selectCreditCardWithToken = selectCreditCardWithToken;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCreditCardLastDigit() {
		return creditCardLastDigit;
	}
	public void setCreditCardLastDigit(String creditCardLastDigit) {
		this.creditCardLastDigit = creditCardLastDigit;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getNameOfCardHolder() {
		return nameOfCardHolder;
	}
	public void setNameOfCardHolder(String nameOfCardHolder) {
		this.nameOfCardHolder = nameOfCardHolder;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	@Override
	public String toString() {
		return "AddPaymentVO [id=" + id + ", typeOfPaymentAccount=" + typeOfPaymentAccount + ", selectCreditCard="
				+ selectCreditCard + ", selectCreditCardWithToken=" + selectCreditCardWithToken + ", creditCard="
				+ creditCard + ", cvc=" + cvc + ", token=" + token + ", creditCardLastDigit=" + creditCardLastDigit
				+ ", cardType=" + cardType + ", nameOfCardHolder=" + nameOfCardHolder + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + ", customerDetails=" + customerDetails + ", publisher=" + publisher + "]";
	}
	 
	
}
