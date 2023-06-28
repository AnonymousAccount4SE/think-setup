package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.Order;
import com.mps.think.setup.service.CustomerDetailsService;
import com.mps.think.setup.vo.CustomerDetailsVO;
import com.mps.think.setup.vo.EnumModelVO.ChargeTaxOn;
import com.mps.think.setup.vo.EnumModelVO.ConfigurationOptionsforOrders;
import com.mps.think.setup.vo.EnumModelVO.CustomerCategory;
import com.mps.think.setup.vo.EnumModelVO.CustomerStatus;
import com.mps.think.setup.vo.EnumModelVO.PaymentOptions;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin
public class CustomerDetailsController {

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@GetMapping("/getAllCustomer")
	public ResponseEntity<?> getAllCustomerDetails() {
		return ResponseEntity.ok(customerDetailsService.getAllCustomerDetails());
	}
	@GetMapping("/getAllCustomercolumns")
	public ResponseEntity<?> findAllColumn() {
		return ResponseEntity.ok(customerDetailsService.findAllColumn());
	}

//	@GetMapping("/getAllCustomersForSearch")
//	public ResponseEntity<?> getAllCustomerDetailsForSearch(@RequestParam(required = false) String firstName,
//			@RequestParam(required = false) String lastName, @RequestParam(defaultValue = "0") Integer page,
//			@RequestParam(defaultValue = "5") Integer size) {
//		return ResponseEntity.ok(
//				customerDetailsService.getAllCustomerDetailsForSearch(firstName, lastName, PageRequest.of(page, size)));
//	}

	@PostMapping("/saveCustomer")
	public ResponseEntity<?> savecustomerDetails(@RequestBody CustomerDetailsVO customerId) {
		return ResponseEntity.ok(customerDetailsService.saveCustomerDetails(customerId));
	}

	@PostMapping("/updateCustomer")
	public ResponseEntity<?> updatecustomerDetails(@RequestBody CustomerDetailsVO customerId) {
		return ResponseEntity.ok(customerDetailsService.updateCustomerDetails(customerId));
	}

	@PostMapping("/findbyCustomerId")
	public ResponseEntity<?> findbyCustomerDetailsId(@RequestBody Integer customerId) {
		return ResponseEntity.ok(customerDetailsService.findbyCustomerDetailsId(customerId));
	}

	@GetMapping("/findAllCustomerByPubId/{pubId}")
	public ResponseEntity<?> findAllCustomerByPubId(@PathVariable("pubId") Integer pubId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(customerDetailsService.findAllCustomerByPubId(pubId,
				PageRequest.of(page, size, Sort.by("customerId").descending())));
	}

	@GetMapping("/getAllCustomerCategory")
	public ResponseEntity<?> getAllCustomerCategory() {
		return ResponseEntity.ok(CustomerCategory.values());
	}

	@GetMapping("/getAllConfigurationOptionsforOrders")
	public ResponseEntity<?> getAllConfigurationOptionsforOrders() {
		return ResponseEntity.ok(ConfigurationOptionsforOrders.values());
	}

	@GetMapping("/getAllPaymentOptions")
	public ResponseEntity<?> getAllPaymentOptions() {
		return ResponseEntity.ok(PaymentOptions.values());
	}

	@GetMapping("/getAllChargeTaxOn")
	public ResponseEntity<?> getAllChargeTaxOn() {
		return ResponseEntity.ok(ChargeTaxOn.values());
	}

	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<?> deleteCustomerById(@RequestBody Integer customerId) {
		return ResponseEntity.ok(customerDetailsService.deleteCustomer(customerId));
	}

	@GetMapping("/getAllCustomerDetailsForSearch")
	public ResponseEntity<?> getAllCustomerDetailsForSearch(@RequestParam(required = true) Integer pubId,
			@RequestParam(required = false) String search, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) throws Exception {
		return ResponseEntity
				.ok(customerDetailsService.getSearchedCustomersWithTwoRecentOrderCodes(pubId, search, PageRequest.of(page, size)));
	}

	@GetMapping("/getAllCustomersRecentTwoOrderCodeUnderPub/{pubId}")
	public ResponseEntity<?> getAllCustomersRecentTwoOrderCodeUnderPub(@PathVariable("pubId") Integer pubId) {
		return ResponseEntity.ok(customerDetailsService.getAllCustomerRecentOrderCodeForPub(pubId));
	}

	@GetMapping("/getRecentPlacedOrderOfCustomer/{customerId}")
	public ResponseEntity<?> getRecentPlacedOrderOfCustomer(@PathVariable("customerId") Integer customerId)
			throws Exception {
		Order recentOrderOfCustomer = customerDetailsService.getRecentOrderOfCustomer(customerId);
		return ResponseEntity.ok(recentOrderOfCustomer != null ? recentOrderOfCustomer : new JSONObject());
	}

	@GetMapping("/getOrderCountOfCustomerForGivenYear")
	public ResponseEntity<?> getOrderCountOfCustomerForGivenYear(@RequestParam(required = true) Integer customerId,
			@RequestParam(required = true) String year) {
		JSONObject json = new JSONObject();
		json.put("orderCount", customerDetailsService.countOfOrdersForGivenCustomerInYear(customerId, year));
		return ResponseEntity.ok(json.toString());
	}

	@GetMapping("/getAllCustomerAgentForSearch")
	public ResponseEntity<?> getAllCustomerAgentForSearch(@RequestParam(required = true) Integer publisher,
			@RequestParam(required = false) String agencyName) {
		return ResponseEntity.ok(customerDetailsService.getAllCustomerAgentForSearch(publisher, agencyName));
	}

	@GetMapping("/getCustomerStatusValues")
	public ResponseEntity<?> getCustomerStatusValues() {
		return ResponseEntity.ok(CustomerStatus.values());
	}

	@PostMapping("/updateCustomerStatusHoldOrInactive")
	public ResponseEntity<?> updateCustomerStatusHoldOrInactive(@RequestBody CustomerDetailsVO customerVO) {
		return ResponseEntity.ok(customerDetailsService.updateCustomerStatus(customerVO));
	}

	@GetMapping("/getAllRecentAddressesOfCustomer")
	public ResponseEntity<?> getAllRecentAddressesOfCustomer(@RequestParam(required = true) Integer customerId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size)
			throws Exception {
		return ResponseEntity
				.ok(customerDetailsService.getRecentAddressWithTheirCustomer(customerId, PageRequest.of(page, size)));
	}

	@GetMapping("/getOtherCustomersWithAddresses")
	public ResponseEntity<?> getOtherCustomers(@RequestParam(required = false) Integer publisherId,
			@RequestParam(required = true) Integer customerId, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(
				customerDetailsService.getOtherCustomerAddresses(publisherId, customerId, PageRequest.of(page, size)));
	}
	
	@GetMapping("/getAllCustomerWithRecentTwoOrderCodes/{pubId}")
	public ResponseEntity<?> findAllCustomerWithRecentTwoOrderCodes(@PathVariable("pubId") Integer pubId, @RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "5") Integer size) throws Exception {
		return ResponseEntity.ok(customerDetailsService.getAllCustomerWithRecentTwoOrderCodes(pubId, PageRequest.of(page, size)));
	}
	
	
	@GetMapping("/getSearchedCustomersWithTwoRecentOrderCodes")
	public ResponseEntity<?> getSearchedCustomersWithTwoRecentOrderCodes(@RequestParam(required = true) Integer pubId,
			@RequestParam(required = false) String search, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) throws Exception {
		return ResponseEntity
				.ok(customerDetailsService.getSearchedCustomersWithTwoRecentOrderCodes(pubId, search, PageRequest.of(page, size, Sort.by("customerId").descending())));
	}
	
}
