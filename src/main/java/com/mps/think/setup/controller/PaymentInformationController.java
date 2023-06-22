package com.mps.think.setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.PaymentInformationService;
import com.mps.think.setup.vo.PaymentInformationVO;

@RestController
@CrossOrigin
public class PaymentInformationController {

	@Autowired
	PaymentInformationService paymentInformationService;

	@PostMapping("/getAllPaymentInformation")
	public ResponseEntity<?> getAllPaymentInformation(@RequestBody Integer pubId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity
				.ok(paymentInformationService.getallPaymentInformationForPublisher(pubId, PageRequest.of(page, size)));
	}

	@PostMapping("/getAllPaymentInformationByCustId")
	public ResponseEntity<?> getAllPaymentInformationByCustId(@RequestBody Integer customerId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(
				paymentInformationService.getallPaymentInformationForCustomer(customerId, PageRequest.of(page, size)));
	}

	@PostMapping("/savePaymentInformation")
	public ResponseEntity<?> savePaymentInformation(@RequestBody List<PaymentInformationVO> paymentInformationVO) {
		return ResponseEntity.ok(paymentInformationService.savePayInfo(paymentInformationVO));
	}

	@PostMapping("/findPaymentInformationById")
	public ResponseEntity<?> findPaymentInformationById(@RequestBody Integer id) {
		return ResponseEntity.ok(paymentInformationService.findByPaymentInfoId(id));
	}

	@PostMapping("/getPaymentInformationByOrderId")
	public ResponseEntity<?> getPaymentInformationByOrderId(@RequestBody Integer orderId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(paymentInformationService.getPaymentInformationByOrderId(orderId, PageRequest.of(page, size)));
	}

}
