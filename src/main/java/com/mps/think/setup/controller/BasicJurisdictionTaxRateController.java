package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.BasicJurisdictionTaxRateService;
import com.mps.think.setup.vo.BasicJurisdictionTaxRateVO;

@RestController
@CrossOrigin
public class BasicJurisdictionTaxRateController {

	@Autowired
	private BasicJurisdictionTaxRateService basicJurisdictionTaxRateService;

	@GetMapping("/findbasicJurisdictionTaxRate")
	public ResponseEntity<?> findAllbasicTaxRatebyId() {
		return ResponseEntity.ok(basicJurisdictionTaxRateService.findbasicJurisdictionTaxRate());
	}

	@PostMapping("/savebasicJurisdictionTaxRate")
	public ResponseEntity<?> saveBasicTaxRate(@RequestBody BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO) {
		return ResponseEntity.ok(basicJurisdictionTaxRateService.savebasicJurisdictionTaxRate(basicJurisdictionTaxRateVO));
	}

	@PostMapping("/updatebasicJurisdictionTaxRate")
	public ResponseEntity<?> updateBasicTaxRate(@RequestBody  BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO) {
		return ResponseEntity.ok(basicJurisdictionTaxRateService.updatebasicJurisdictionTaxRate(basicJurisdictionTaxRateVO));
	}

	@PostMapping("/findbasicJurisdictionTaxRatebyId")
	public ResponseEntity<?> findbasicTaxRatebyId(@RequestBody Integer id) {
		return ResponseEntity.ok(basicJurisdictionTaxRateService.findbasicJurisdictionTaxRatebyId(id));
	}

}
