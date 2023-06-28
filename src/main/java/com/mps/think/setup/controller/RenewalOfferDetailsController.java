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

import com.mps.think.setup.service.RenewalOfferDetailsService;
import com.mps.think.setup.vo.RenewalOfferDetailsVO;

@RestController
@CrossOrigin
public class RenewalOfferDetailsController {

	@Autowired
	RenewalOfferDetailsService renewalOfferDetailsService;

	@GetMapping("/getRenewalOfferDetails")
	public ResponseEntity<?> findAllRenewalOfferDetails() {
		return ResponseEntity.ok(renewalOfferDetailsService.findAllRenewalOfferDetails());
	}

	@PostMapping("/saveRenewalOfferDetails")
	public ResponseEntity<?> saveRenewalOfferDetails(@RequestBody RenewalOfferDetailsVO renewalOfferDetailsVO) {
		return ResponseEntity.ok(renewalOfferDetailsService.saveRenewalOfferDetails(renewalOfferDetailsVO));
	}

	@PutMapping("/updateRenewalOfferDetails")
	public ResponseEntity<?> updateRenewalOfferDetails(@RequestBody RenewalOfferDetailsVO renewalOfferDetailsVO) {
		return ResponseEntity.ok(renewalOfferDetailsService.updateRenewalOfferDetails(renewalOfferDetailsVO));
	}

	@DeleteMapping("/deleteRenewalOfferDetails")
	public ResponseEntity<?> deleteRenewalOfferDetails(@RequestBody Integer renewalOfferDetailsId) {
		return ResponseEntity.ok(renewalOfferDetailsService.deleteRenewalOfferDetails(renewalOfferDetailsId));
	}

	@PostMapping("/findByRenewalOfferDetailsId")
	ResponseEntity<?> findByRenewalOfferDetailsId(@RequestBody Integer renewalOfferDetailsId) {
		return ResponseEntity.ok(renewalOfferDetailsService.findbyRenewalOfferDetailsId(renewalOfferDetailsId));
	}

	@PostMapping("/getAllRenewalOfferDetailsByAddRenewalsId")
	ResponseEntity<?> findAllRenewalOfferDetailsByAddRenewalsId(@RequestBody Integer id) {
		return ResponseEntity
				.ok(renewalOfferDetailsService.findAllRenewalOfferDetailsByAddRenewalsId(id));
	}
//	@GetMapping("/getAllRenewalOfferDetailsByAddRenewalsId/{id}")
//	public ResponseEntity<?> findAllRenewalOfferDetailsByAddRenewalsId(@PathVariable("id") Integer id,
//			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
//		return ResponseEntity.ok(renewalOfferDetailsService.findAllRenewalOfferDetailsByAddRenewalsId(id,
//				PageRequest.of(page, size)));
//	}
}
