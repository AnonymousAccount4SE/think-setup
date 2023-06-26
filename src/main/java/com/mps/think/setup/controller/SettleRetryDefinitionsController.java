package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.SettleRetryDefinitionsService;
 import com.mps.think.setup.vo.SettleRetryDefinitionsVO;
import com.mps.think.setup.vo.ShippingMethodVO;
 
@RestController
public class SettleRetryDefinitionsController {

	
	@Autowired
	private SettleRetryDefinitionsService settleRetryDefinitionsService;
	
	@GetMapping("/getAllSettleRetryDefinitions")
	public ResponseEntity<?> getAllSettleRetryDefinitions() {
		return ResponseEntity.ok(settleRetryDefinitionsService.getAllSettleRetryDefinitions());
	}
	
	@PostMapping("/getAllSettleRetryDefinitionsForPublisher")
	public ResponseEntity<?> getAllSettleRetryDefinitionsForPublisher(@RequestBody Integer pubId){
		return ResponseEntity.ok(settleRetryDefinitionsService.getAllSettleRetryDefinitionsForPublisher(pubId));
	}
	
	@PostMapping("/saveSettleRetryDefinitions")
	public ResponseEntity<?> saveSettleRetryDefinitions(@RequestBody SettleRetryDefinitionsVO settleRetryDefinitions) {
		return ResponseEntity.ok(settleRetryDefinitionsService.saveSettleRetryDefinitions(settleRetryDefinitions));
	}
	
	@PutMapping("/updateSettleRetryDefinitions")
	public ResponseEntity<?> updateSettleRetryDefinitions(@RequestBody SettleRetryDefinitionsVO settleRetryDefinitions) {
		return ResponseEntity.ok(settleRetryDefinitionsService.updateSettleRetryDefinitions(settleRetryDefinitions));
	}
	
	@PostMapping("/findSettleRetryDefinitionsById")
	public ResponseEntity<?> findSettleRetryDefinitionsById(@RequestBody Integer id) {
		return ResponseEntity.ok(settleRetryDefinitionsService.getSettleRetryDefinitionsByid(id));
	}
	@DeleteMapping("/deleteSettleRetryDefinitionsById")
	public ResponseEntity<?> deleteSettleRetryDefinitionsById(@RequestBody Integer id) {
		return ResponseEntity.ok(settleRetryDefinitionsService.deleteSettleRetryDefinitionsById(id));
	}
}
