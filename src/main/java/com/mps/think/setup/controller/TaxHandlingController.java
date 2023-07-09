package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.serviceImpl.TaxHandlingServiceImpl;
import com.mps.think.setup.vo.TaxHandlingVO;


@RestController
@CrossOrigin
public class TaxHandlingController {
	
	@Autowired
	private TaxHandlingServiceImpl taxHandlingServiceImpl;
	
	@GetMapping("/getAllTaxHandling")
	public ResponseEntity<?> getAllInserts() {
		return ResponseEntity.ok(taxHandlingServiceImpl.getAllTaxHandling());
	}
	
	@PostMapping("/saveAddTaxHandling")
	public ResponseEntity<?> saveInserts(@RequestBody TaxHandlingVO taxHandlingVO) {
		return ResponseEntity.ok(taxHandlingServiceImpl.saveAddTaxHandling(taxHandlingVO));
	}
	
	@PostMapping("/updateAddTaxHandling")
	public ResponseEntity<?> updateInserts(@RequestBody TaxHandlingVO taxHandlingVO) {
		return ResponseEntity.ok(taxHandlingServiceImpl.updateAddTaxHandling(taxHandlingVO));	
		}
	
	@PostMapping("/findbyAddTaxHandlingId")
	public ResponseEntity<?> findbySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(taxHandlingServiceImpl.findbyAddTaxHandlingId(id));
	}
	
	@PostMapping("/findbyAddTaxHandlingpubId")
	public ResponseEntity<?> findbypubId(@RequestBody Integer pubId) {
		return ResponseEntity.ok(taxHandlingServiceImpl.findbyAddTaxHandlingpubId(pubId));
	}
	
	@DeleteMapping("/deleteByTaxHandlingId")
	public ResponseEntity<?> deleteBySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(taxHandlingServiceImpl.deleteByTaxHandlingId(id));
	}
}
