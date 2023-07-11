package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.BasicTaxRateService;
import com.mps.think.setup.vo.BasicTaxRateVO;

@RestController
@CrossOrigin
public class BasicTaxRateController {

	@Autowired
	private BasicTaxRateService basicTaxRateService;

	@GetMapping("/findAllbasicTaxRatebyId")
	public ResponseEntity<?> findAllbasicTaxRatebyId() {
		return ResponseEntity.ok(basicTaxRateService.findAllbasicTaxRatebyId());
	}

	@PostMapping("/saveBasicTaxRate")
	public ResponseEntity<?> saveBasicTaxRate(@RequestBody BasicTaxRateVO basicTaxRateVO) {
		return ResponseEntity.ok(basicTaxRateService.saveBasicTaxRate(basicTaxRateVO));
	}

	@PostMapping("/updateBasicTaxRate")
	public ResponseEntity<?> updateBasicTaxRate(@RequestBody BasicTaxRateVO basicTaxRateVO) {
		return ResponseEntity.ok(basicTaxRateService.updateBasicTaxRate(basicTaxRateVO));
	}

	@PostMapping("/findById")
	public ResponseEntity<?> findbasicTaxRatebyId(@RequestBody Integer id) {
		return ResponseEntity.ok(basicTaxRateService.findById(id));
	}

	
	@PostMapping("/findByTaxRateId")
	public ResponseEntity<?> findByTaxRateId(@RequestBody Integer taxRateId) {
		return ResponseEntity.ok(basicTaxRateService.findByTaxRateId(taxRateId));
	}
}
