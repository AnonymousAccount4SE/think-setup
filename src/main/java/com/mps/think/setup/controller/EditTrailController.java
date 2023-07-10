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
	public ResponseEntity<?> getCustomerHistory(@RequestParam Integer pubId, @RequestParam(required = false) Integer customerId,
			@RequestParam(required = false) Integer orderId, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(editTrailService.findEditTrialById(pubId, customerId, orderId, PageRequest.of(page, size)));
	}
}
