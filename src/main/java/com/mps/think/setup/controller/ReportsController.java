package com.mps.think.setup.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.ReportsService;

@RestController
@CrossOrigin
public class ReportsController {
	
	@Autowired
	private ReportsService reportsService;
	
	

	@GetMapping("/getAllOrderReports")
	public ResponseEntity<?> getAllOrderReports(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String orderStatus, @RequestParam(required = false) String ordersFrom,
			@RequestParam(required = false) String ordersTill, @RequestParam(required = false) Integer customerId, @RequestParam(required = false) String customerName, 
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException {
		Date ordersFromDate = (ordersFrom == null || ordersFrom.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(ordersFrom);
		Date ordersTillDate = (ordersTill == null || ordersTill.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(ordersTill);
		return ResponseEntity.ok(reportsService.getAllOrderReports(pubId, orderStatus, ordersFromDate, ordersTillDate, customerId, customerName, PageRequest.of(page, size)));
	}
	
	@GetMapping("/getAllCustomerSearchReport")
	
	public ResponseEntity<?> getAllCustomerSearchReport(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) Integer customerId, @RequestParam(required = false) String fname,
			@RequestParam(required = false) String lname, @RequestParam(required = false) String initialName, @RequestParam(required = false) String email, 
			@RequestParam(required = false) String company, @RequestParam(required = false) String department, @RequestParam(required = false) String country, 
			@RequestParam(required = false) String state, @RequestParam(required = false) String city, @RequestParam(required = false) Integer zipCode, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(reportsService.getAllCustomerSearchReport(pubId, customerId, fname, lname, initialName, email, company, department, country, state, city, zipCode, PageRequest.of(page, size)));
	}
	
	 @GetMapping("/getAllCancelledSubscriptions") 
	 public ResponseEntity<?> getAllCancelledSubscriptions(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String orderFrom, @RequestParam(required = false) String orderTill,
				@RequestParam(required = false) String currencyType,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 Date ordersFromDate = (orderFrom == null || orderFrom.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(orderFrom);
			Date ordersTillDate = (orderTill == null || orderTill.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(orderTill);
		 return ResponseEntity.ok(reportsService.getAllCancelledSubscriptions(pubId, ordersFromDate, ordersTillDate, currencyType, PageRequest.of(page, size)));
	 }
	 
	 @GetMapping("/getAllCustomerSalesList") 
	 public ResponseEntity<?> getAllCustomerSalesList(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String oredrStart,
				@RequestParam(required = false) String orderEnd,@RequestParam(required = false)String orderType,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 Date ordersFromDate = (oredrStart == null || oredrStart.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(oredrStart);
			Date ordersTillDate = (orderEnd == null || orderEnd.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(orderEnd);
		 return ResponseEntity.ok(reportsService.getAllCustomerSalesList(pubId, ordersFromDate, ordersTillDate, orderType, PageRequest.of(page, size)));
	 }
	 @GetMapping("/getAllDailyCashReport") 
	 public ResponseEntity<?> getAllDailyCashReport(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String paymentStart,
				@RequestParam(required = false) String paymentEnd,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 Date paymentFromDate = (paymentStart == null || paymentStart.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(paymentStart);
			Date paymentTillDate = (paymentEnd == null || paymentEnd.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(paymentEnd);
		 return ResponseEntity.ok(reportsService.getAllDailyCashReport(pubId, paymentFromDate, paymentTillDate, PageRequest.of(page, size)));
	 }
	 
	 @GetMapping("/getAllRefundProcessReport") 
	 public ResponseEntity<?> getAllRefundProcessReport(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String startRefund,
				@RequestParam(required = false) String endRefund,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 Date refundFromDate = (startRefund == null || startRefund.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(startRefund);
			Date refundTillDate = (endRefund == null || endRefund.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(endRefund);
		 return ResponseEntity.ok(reportsService.getAllRefundProcessReport(pubId, refundFromDate, refundTillDate, PageRequest.of(page, size)));
	 }
	 
	 @GetMapping("/getAllCustomerDetatilsReport") 
	 public ResponseEntity<?> getAllCustomerDetatilsReport(@RequestParam(required = false) Integer pubId,
				@RequestParam(required = false) String status,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 
		 return ResponseEntity.ok(reportsService.getAllCustomerDetatilsReport(pubId, status, PageRequest.of(page, size)));
	 }
	 
	 @GetMapping("/getAllAgencyDetailsReport") 
	 public ResponseEntity<?> getAllAgencyDetailsReport(@RequestParam(required = false) Integer pubId,
				@RequestParam(required = false) String status,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 
		 return ResponseEntity.ok(reportsService.getAllAgencyDetailsReport(pubId, status, PageRequest.of(page, size)));
	 }
	 
	 @GetMapping("/getAllSalesListByOrderViewReport") 
	 public ResponseEntity<?> getAllSalesListByOrderViewReport(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String orderStartDate,
				@RequestParam(required = false) String orderEndDate, @RequestParam(required = false) String orderType, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 Date orderFromDate = (orderStartDate == null || orderStartDate.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(orderStartDate);
			Date orderTillDate = (orderEndDate == null || orderEndDate.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(orderEndDate);
		 return ResponseEntity.ok(reportsService.getAllSalesListByOrderViewReport(pubId, orderFromDate, orderTillDate, orderType, PageRequest.of(page, size)));
	 }
	 
	 @GetMapping("/getAllCreditCardDeclinedView") 
	 public ResponseEntity<?> getAllCreditCardDeclinedView(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String paymentStartDate,
				@RequestParam(required = false) String paymentEndDate, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 Date paymentStartDate1 = (paymentStartDate == null || paymentStartDate.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(paymentStartDate);
			Date paymentEndDate1 = (paymentEndDate == null || paymentEndDate.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(paymentEndDate);
		 return ResponseEntity.ok(reportsService.getAllCreditCardDeclinedViewReport(pubId, paymentStartDate1, paymentEndDate1, PageRequest.of(page, size)));
	 }
	 
	 @GetMapping("/getAllDailyCreditCardAndPaymentReport") 
	 public ResponseEntity<?> getAllDailyCreditCardAndPaymentReport(@RequestParam(required = false) Integer pubId, @RequestParam(required = false) String paymentStartDate,
				@RequestParam(required = false) String paymentEndDate, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws ParseException{
		 
		 Date paymentStartDate1 = (paymentStartDate == null || paymentStartDate.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(paymentStartDate);
			Date paymentEndDate1 = (paymentEndDate == null || paymentEndDate.isEmpty()) ? null : new SimpleDateFormat("dd/MM/yyyy").parse(paymentEndDate);
		 return ResponseEntity.ok(reportsService.getAllDailyCreditCardAndPaymentReport(pubId, paymentStartDate1, paymentEndDate1, PageRequest.of(page, size)));
	 }
}
