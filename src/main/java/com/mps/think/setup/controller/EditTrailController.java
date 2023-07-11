package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.EditTrailService;

@RestController
@CrossOrigin
public class EditTrailController {

	@Autowired
	EditTrailService editTrailService;

	@GetMapping("/getHistoryByCustomerId")
	public ResponseEntity<?> getHistoryByCustomerId(@RequestParam Integer id) {
		return ResponseEntity.ok(editTrailService.getAllEditTrailByCustId(id));
	}

	@GetMapping("/getCustomerHistory")
	public ResponseEntity<?> getOrderHistory(@RequestParam Integer pubId, @RequestParam Integer customerId,
			@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(editTrailService.findEditTrialForCustomerHistory(pubId, customerId, PageRequest.of(page, size)));
	}
	
	
	@GetMapping("/getOrderHistoryByCustId")
	public ResponseEntity<?> getOrderHistoryByCustId(@RequestParam Integer pubId, @RequestParam Integer customerId,
			@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(editTrailService.findEditTrialForOrderHistory(pubId, customerId, PageRequest.of(page, size)));
	}
	
	@GetMapping("/getPaymentHistoryByCustId")
	public ResponseEntity<?> getPaymentHistoryByCustId(@RequestParam Integer pubId, @RequestParam Integer customerId,
			@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(editTrailService.findEditTrialForPaymentHistory(pubId, customerId, PageRequest.of(page, size)));
	}
}
