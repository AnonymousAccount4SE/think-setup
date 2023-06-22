package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.RefundDepositDetailsService;
import com.mps.think.setup.vo.RefundDepositDetailsVO;

@RestController
@CrossOrigin
public class RefundDepositDetailsController {

	@Autowired
	RefundDepositDetailsService refundDepositDetailsService;

	@PostMapping("/saveRefundDepositDetails")
	public ResponseEntity<?> saveRefundDepositDetails(@RequestBody RefundDepositDetailsVO refundDepositDetails) {
		return ResponseEntity.ok(refundDepositDetailsService.saveRefundDepositDetails(refundDepositDetails));
	}

	@PutMapping("/updateRefundDepositDetails")
	public ResponseEntity<?> updateRefundDepositDetails(@RequestBody RefundDepositDetailsVO refundDepositDetails) {
		return ResponseEntity.ok(refundDepositDetailsService.updateRefundDepositDetails(refundDepositDetails));
	}

	@GetMapping("/findRefundDepositDetailsById/{id}")
	public ResponseEntity<?> findRefundDepositDetailsById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(refundDepositDetailsService.findRefundDepositDetailsById(id));
	}
		
	@GetMapping("/findAllRefundDepositDetailsForCustomer/{customerId}")
	public ResponseEntity<?> findAllRefundDepositDetailsForCustomer(@PathVariable("customerId") Integer customerId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(refundDepositDetailsService.findAllRefundDepositDetailsForCustomer(customerId, PageRequest.of(page, size)));
	}

	@GetMapping("/findAllRefundDepositDetailsForPublisher/{pubId}")
	public ResponseEntity<?> findAllRefundDepositDetails(@PathVariable("pubId") Integer pubId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(refundDepositDetailsService.findAllDepositDetails(pubId, PageRequest.of(page, size)));
	}

	@DeleteMapping("/deleteRefundDepositDetails/{id}")
	public ResponseEntity<?> deleteRefundDepositDetails(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(refundDepositDetailsService.deleteRefundDepositDetails(id));
	}

}
