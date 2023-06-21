package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.WithdrawalDetailsService;
import com.mps.think.setup.vo.WithdrawalDetailsVO;

@RestController
public class WithdrawalDetailsController {

	@Autowired
	WithdrawalDetailsService service;
	
	@PostMapping("/saveWithdrawalDetails")
	public ResponseEntity<?> saveWithdrawalDetails(@RequestBody WithdrawalDetailsVO withdrawalDetails) {
		return ResponseEntity.ok(service.saveWithdrawalDetails(withdrawalDetails));
	}

	@PutMapping("/updateWithdrawalDetails")
	public ResponseEntity<?> updateWithdrawalDetails(@RequestBody WithdrawalDetailsVO withdrawalDetails) {
		return ResponseEntity.ok(service.updateWithdrawalDetails(withdrawalDetails));
	}
	
	@GetMapping("/findWithdrawalDetailsById/{id}")
	public ResponseEntity<?> findWithdrawalDetailsById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(service.findWithdrawalDetailsById(id));
	}
	
	@GetMapping("/findAllWithdrawalDetailsForCustomer/{customerId}")
	public ResponseEntity<?> findAllWithdrawalDetailsForCustomer(@PathVariable("customerId") Integer customerId, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(service.findWithdrawalDetailsForCustomer(customerId, PageRequest.of(page, size)));
	}
	
	@GetMapping("/findAllWithdrawalDetailsForPublisher/{pubId}")
	public ResponseEntity<?> findAllWithdrawalDetailsForPublisher(@PathVariable("pubId") Integer pubId, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(service.findAllWithdrawalDetailsForPublisher(pubId, PageRequest.of(page, size)));
	}
	
	@DeleteMapping("/deleteWithdrawalDetails/{id}")
	public ResponseEntity<?> deleteWithdrawalDetails(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(service.deleteWithdrawalDetails(id));
	}
	
}
