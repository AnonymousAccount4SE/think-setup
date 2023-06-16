package com.mps.think.setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.AddPayment;
import com.mps.think.setup.service.AddPaymentService;
import com.mps.think.setup.vo.AddPaymentVO;
import com.mps.think.setup.vo.AuxVariableVO;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin
public class AddPaymentController {
	
	@Autowired
	AddPaymentService addPaymentService;
	

	@PostMapping("/findAllPaymentForPublisher")
	public ResponseEntity<?> findAllPaymentForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(addPaymentService.findAllPaymentForPublisher(pubId));
	}

	@PostMapping("/savePayment")
	public ResponseEntity<?> savePayment(@RequestBody AddPaymentVO paymentVO) {
		return ResponseEntity.ok(addPaymentService.savePayment(paymentVO));
	}
	
	@PostMapping("/updatePayment")
	public ResponseEntity<?> updatePayment(@RequestBody AddPaymentVO paymentVO) {
		return ResponseEntity.ok(addPaymentService.updatePayment(paymentVO));
	}
	
	@PostMapping("/findbyPaymentId")
	public ResponseEntity<?> findbyPaymentId(@RequestBody Integer id) {
		return ResponseEntity.ok(addPaymentService.findbyPaymentId(id));
	}
	
	@PostMapping("/findByCustomerDetailsCustomerId")
	public ResponseEntity<?> findByCustomerDetailsCustomerId(@RequestBody Integer customerId) throws Exception {
		List<AddPayment> addPaymentDetails = addPaymentService.findByCustomerDetailsCustomerId(customerId);
		return ResponseEntity.ok(addPaymentDetails != null ? addPaymentDetails : new JSONObject());
	}
}
