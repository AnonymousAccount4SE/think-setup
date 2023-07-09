package com.mps.think.setup.vo;

public class EnumModelVO {
	public static enum Currency {

		USD("USD"), INR("INR"), POUND("POUND"), EURO("EURO");

		private final String displayCurrency;

		Currency(String displayCurrency) {
			this.displayCurrency = displayCurrency;
		}

		public String getDisplayName() {
			return displayCurrency;
		}
	}

	public static enum DateFormat {

		MMDDYY("MMDDYY"), DDMMYY("DDMMYY"), YYMMDD("YYMMDD");

		private final String displayDateFormat;

		DateFormat(String displayDateFormat) {
			this.displayDateFormat = displayDateFormat;
		}

		public String getDisplayName() {
			return displayDateFormat;
		}
	}

	public static enum TimeZone {

		IST("IST"), AEST("AEST"), ACST("ACST"), AWST("AWST"), PDT("PDT"), MST("MST"), MDT("MDT"), CST("CST"),
		CDT("CDT"), EST("EST"), EDT("EDT"), AST("AST"), ADT("ADT"), NDT("NDT"), BST("BST"), HST("HST"), HDT("HDT"),
		AKDT("AKDT");

		private final String displayTimeZone;

		TimeZone(String displayTimeZone) {
			this.displayTimeZone = displayTimeZone;
		}

		public String getDisplayName() {
			return displayTimeZone;
		}
	}

	public static enum SubDefStatus {

		ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

		private final String status;

		private SubDefStatus(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

	}

	public static enum StartType {

		ANYTIME_START("ANYTIME START"), VOLUME_GROUP_START("VOLUME GROUP START"),
		DATE_BASED_WITH_ISSUES("DATE BASED WITH ISSUES"), DATE_BASED_WITH_NO_ISSUES("DATE BASED WITH NO ISSUES"),
		DATE_BASED_WITH_UNITS("DATE BASED WITH UNITS"), UNIT_BASED_NO_TIME("UNIT BASED NO TIME"), ANY("ANY");

		private final String displayStartType;

		StartType(String displayStartType) {
			this.displayStartType = displayStartType;
		}

		public String getDisplayName() {
			return displayStartType;
		}
	}

	public static enum InstallmentTerm {

		MONTHLY("MONTHLY"), YEARLY("YEARLY"), HALF_YEARLY("HALF YEARLY");

		private final String displayInstallmentTerm;

		InstallmentTerm(String displayInstallmentTerm) {
			this.displayInstallmentTerm = displayInstallmentTerm;
		}

		public String getDisplayName() {
			return displayInstallmentTerm;
		}
	}

	public static enum Source_code_type {

		Zero("Basic"), One("Package"), Two("Dual"), Three("Catalog"), four("Generic"), five("Shipping");

		private String displayName;

		Source_code_type(String displayName) {
			this.displayName = displayName;
		}

		public String displayName() {
			return displayName;
		}

		@Override
		public String toString() {
			return displayName;
		}
	}

	public static enum AddressType {

		Business("Business"), Residential("Residential");

		private final String displayAddressType;

		AddressType(String displayAddressType) {
			this.displayAddressType = displayAddressType;
		}

		public String getDisplayName() {
			return displayAddressType;
		}

	}

	public static enum AddressCategory {

		ShippingAddress("Shipping Address"), BillingAddress("Billing Address"), RenewalAddress("Renewal Address"),
		AlternateAddress("Alternate Address");

		private final String displayAddressCategory;

		AddressCategory(String displayAddressCategory) {
			this.displayAddressCategory = displayAddressCategory;
		}

		public String getDisplayName() {
			return displayAddressCategory;
		}

	}

	public static enum Frequency {

		EveryYear("Every Year"), None("None");

		private final String displayFrequency;

		Frequency(String displayFrequency) {
			this.displayFrequency = displayFrequency;
		}

		public String getDisplayName() {
			return displayFrequency;
		}

	}

	public static enum CustomerCategory {

		Agency("Agency"), Individual("Individual"), Institutional("Institutional");

		private final String displayCustomerCategory;

		CustomerCategory(String displayCustomerCategory) {
			this.displayCustomerCategory = displayCustomerCategory;
		}

		public String getDisplayName() {
			return displayCustomerCategory;
		}

	}

	public static enum ConfigurationOptionsforOrders {

		BundleDiscounts("Bundle Discounts"), BillToAgency("Bill to Agency"), RenewToAgency("Renew to Agency");

		private final String displayConfigurationOptionsforOrders;

		ConfigurationOptionsforOrders(String displayConfigurationOptionsforOrders) {
			this.displayConfigurationOptionsforOrders = displayConfigurationOptionsforOrders;
		}

		public String getDisplayName() {
			return displayConfigurationOptionsforOrders;
		}

	}

	public static enum PaymentOptions {

		PayCommissionToAgency("Pay Commission to Agency"), AgencyRemitsNetPayment("Agency Remits Net Payment");

		private final String displayPaymentOptions;

		PaymentOptions(String displayPaymentOptions) {
			this.displayPaymentOptions = displayPaymentOptions;
		}

		public String getDisplayName() {
			return displayPaymentOptions;
		}

	}

	public static enum ChargeTaxOn {

		AgencyPaysTax("Agency Pays Tax"), TaxChargedOnGross("Tax Charged On Gross"),
		TaxChargedOnNet("Tax Charged On Net");

		private final String displayChargeTaxOn;

		ChargeTaxOn(String displayChargeTaxOn) {
			this.displayChargeTaxOn = displayChargeTaxOn;
		}

		public String getDisplayName() {
			return displayChargeTaxOn;
		}

	}

	public static enum PaymentStatus {

		NO_PAYMENT("No Payment"), PARTIAL_PAYMENT("Partial Payment"), PAID_OVERPAYMENT("Paid - Overpayment"), 
		PAID_UNDERPAYMENT("Paid - Underpayment"), PAID_PRORATED("Paid Prorated"), PAID("Paid"), 
		NO_PAYMENT_REJECTED("No Payment Rejected"), NO_PAYMENT_REFUNDED("No Payment Refunded"), 
		PAID_REFUNDED("Paid Refunded"), UNDERPAYMENT("Underpayment"), REFUND_PAYMENTS("Refund payments"),
		OVERPAYMENT("Overpayment");

		private final String displaypaymentStatus;

		PaymentStatus(String displaypaymentStatus) {
			this.displaypaymentStatus = displaypaymentStatus;
		}

		public String getDisplayName() {
			return displaypaymentStatus;
		}
	}

	public static enum OrderStatus {

//		Active("Active"), Cancelled("Cancelled"), Pending("Pending"), SUSPENDED_TEMP("Suspended-Temporary"), SUSPEND_NON_PAY("Suspend Non-Pay");
		
		order_placed("order placed"), active_shipping("active/shipping"),
		cancel_for_nonpayment("cancel for nonpayment"), cancel_customer_request("cancel - customer request"),
		cancel_waiting_credit_card_authorization("cancel/waiting credit card authorization"),
		partial_shipment("partial shipment"),shipped_complete("shipped complete"),grace("grace"),
		suspend_for_nonpayment("suspend for nonpayment"),temporary_suspend("temporary suspend"),hold_for_payment("hold for payment"),
		suspend_not_deliverable("suspend not deliverable"), non_verify_cancellation("non-verify cancellation");

		private final String displayOrderStatus;

		OrderStatus(String displayOrderStatus) {
			this.displayOrderStatus = displayOrderStatus;
		}

		public String getDisplayName() {
			return displayOrderStatus;
		}
	}

	public static enum OrderType {

		SingleCopyOrder("Single Copy Order"), BasicPackageOrder("Basic Package Order"),
		DateBasedSubscriptionOrder("Date Based Order"), IssueBasedSubscriptionOrder("Issue Based Subscription Order");

		private final String displayOrderType;

		OrderType(String displayOrderType) {
			this.displayOrderType = displayOrderType;
		}

		public String getDisplayName() {
			return displayOrderType;
		}
	}

	public static enum ItemType {

		Issue("Issue"), Day("Day");

		private final String displayItemType;

		ItemType(String displayItemType) {
			this.displayItemType = displayItemType;
		}

		public String getDisplayName() {
			return displayItemType;
		}
	}

	public static enum Status {

		Active("Active"), Inactive("Inactive");

		private final String displayStatus;

		Status(String displayStatus) {
			this.displayStatus = displayStatus;
		}

		public String getDisplayName() {
			return displayStatus;
		}
	}

	public static enum RefundTo {

		One("Original Source"), Two("Deposit Account"), Three("Payment Account"), Four("Others");

		private final String displayRefundTo;

		RefundTo(String displayRefundTo) {
			this.displayRefundTo = displayRefundTo;
		}

		public String getDisplayName() {
			return displayRefundTo;
		}
	}

	public static enum CustomerStatus {
		Active("Active"), Inactive("Inactive"), Hold("Hold");

		private final String customerStatus;

		CustomerStatus(String customerStatus) {
			this.customerStatus = customerStatus;
		}

		public String getCustomerStatus() {
			return customerStatus;
		}
	}
	
	public static enum RealiseCashWhen {
		
		AUTHORISED("Authorised"), CLEARED("Cleared");
		
		private final String realiseCash;

		RealiseCashWhen(String realiseCash) {
			this.realiseCash = realiseCash;
		}

		public String getRealiseCash() {
			return realiseCash;
		}
		
	}
	
	public static enum CVVValues {
		
		NOTREQUIRED("Not Required"), REQUIRED("Required");
		private final String cvv;
		
		CVVValues(String cvv) {
			this.cvv = cvv;
		}
		public String getCvv() {
			return cvv;
		}
	
	}
	public static enum Mode {
		One("Print"), Two("File"), Three("Window"), Four("Unused");

		private final String mode;

		Mode(String mode) {
			this.mode = mode;
		}

		public String getMode() {
			return mode;
		}
	}
	
	public static enum Interval {
		Minute("Minute"), Day("Day"), Month("Month");

		private final String interval;

		Interval(String interval) {
			this.interval = interval;
		}

		public String getInterval() {
			return interval;
		}
	}
	
	public static enum Type {
		One("By Issues"), Two("By Volume Group"), Three("Requal");

		private final String type;

		Type(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
	
	public static enum EffortType {
		One("Issues/Unitd Left"), Two("Issues/Unitd Left With Expire"), Three("At Birth"),
		Four("By Package Expire Date") , Five("By Subscription Expire Date"), Six("Extract Issues/Units Left");

		private final String effortType;

		EffortType(String effortType) {
			this.effortType = effortType;
		}

		public String getEffortType() {
			return effortType;
		}
	}
	
	public static enum SendTo {
		One("Donor"), Two("Recipient");

		private final String sendTo;

		SendTo(String sendTo) {
			this.sendTo = sendTo;
		}

		public String getSendTo() {
			return sendTo;
		}
	}
	
	public static enum Pricing {
		One("Use Expire Date"), Two("Use Run Date");

		private final String pricing;

		Pricing(String pricing) {
			this.pricing = pricing;
		}

		public String getPricing() {
			return pricing;
		}
	}
	
	public static enum ExemptStatus {
		One("Not Tax Exempt"), Two("Yes Tax Exempt"), Three("Always Tax Exempt");

		private final String exemptStatus;

		ExemptStatus(String exemptStatus) {
			this.exemptStatus = exemptStatus;
		}

		public String getExemptStatus() {
			return exemptStatus;
		}
	}
	public static enum Addressstatus {
		One("ABUSER: Suspected Abuser"), Two("CLEARED Address Cleared"), Three("DEC Deceased"),
		Four("DO NOT MAIL Requested Do Not Mail"), Five("DUPE Duplicate"), Six("HOLD Hold Account"),
		Seven("NCOA NCOA Reported Undeliverable"), Eight("OPEN Open Account"), Nine("OPEN-No Mail Open Account - request no mail")
		, Ten("SUSPEND USPS Temp Service Suspension"), Eleven("UNDEL Return Undeliverable");
		private final String addressstatus;

		Addressstatus(String addressstatus) {
			this.addressstatus = addressstatus;
		}

		public String getAddressstatus() {
			return addressstatus;
		}
	}
	public static enum Region {
		One("Asia"), Two("Africa"), Three("Antarctica"), Four("Australia"), Five("Europe") , Six("North America"), Seven("South America");

		private final String region;

		Region(String region) {
			this.region = region;
		}

		public String getRegion() {
			return region;
		}
	}
	
	public static enum TaxComputation {
		One("None"), Two("Avalara"), Three("Taxjar");

		private final String taxComputation;

		TaxComputation(String taxComputation) {
			this.taxComputation = taxComputation;
		}

		public String getTaxComputation() {
			return taxComputation;
		}
	}
	
	public static enum AddressValidation {
		One("None"), Two("Avalara");

		private final String addressValidation;

		AddressValidation(String addressValidation) {
			this.addressValidation = addressValidation;
		}

		public String getAddressValidation() {
			return addressValidation;
		}
	}
	
	public static enum StateCode {
		One("Canada"), Two("US"), Three("UK");

		private final String stateCode;

		StateCode(String stateCode) {
			this.stateCode = stateCode;
		}

		public String getStateCode() {
			return stateCode;
		}
	}
	
	public static enum CancelType {
		One("Customer Requested"), Two("Non-verify/Controlled"), Three("Non-payment"), Four("Old Demographics");

		private final String cancelType;

		CancelType(String cancelType) {
			this.cancelType = cancelType;
		}

		public String getCancelType() {
			return cancelType;
		}
	}

}
