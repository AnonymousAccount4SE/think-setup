package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.TaxRateService;
import com.mps.think.setup.service.TaxService;
import com.mps.think.setup.vo.TaxRateVO;
import com.mps.think.setup.vo.TaxTypeVO;

@RestController
@CrossOrigin
public class TaxRateController {

	@Autowired
	TaxRateService taxService;

	@GetMapping("/getAllTaxRate")
	public ResponseEntity<?> getAllTaxRate() {
		return ResponseEntity.ok(taxService.findAllTaxType());
	}

	@PostMapping("/saveTaxRate")
	public ResponseEntity<?> saveTaxRate(@RequestBody TaxRateVO taxRateVO) {
		return ResponseEntity.ok(taxService.saveTaxRate(taxRateVO));
	}

	@PostMapping("/updateTaxRate")
	public ResponseEntity<?> updateTaxRate(@RequestBody TaxRateVO taxRateVO) {
		return ResponseEntity.ok(taxService.updateTaxRate(taxRateVO));
	}

	@PostMapping("/findbyTaxRateId")
	public ResponseEntity<?> findbyTaxRate(@RequestBody Integer taxId) {
		return ResponseEntity.ok(taxService.findbyTaxRate(taxId));
	}
	
	@DeleteMapping("/deleteByTaxRateId")
	public ResponseEntity<?> deleteByTaxRateId(@RequestBody Integer taxId) {
		return ResponseEntity.ok(taxService.deleteByTaxRateId(taxId));
	}

//	@PostMapping("/getAllTaxTypeForPublisher")
//	public ResponseEntity<?> findAllTaxTypeForPublisher(@RequestBody Integer pubId) {
//		return ResponseEntity.ok(taxServiceImpl.findAllTaxTypeForPublisher(pubId));
//	}

}
