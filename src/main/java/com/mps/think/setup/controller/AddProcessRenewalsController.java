package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.AddProcessRenewalsService;
import com.mps.think.setup.vo.AddProcessRenewalsVO;

@RestController
@CrossOrigin
public class AddProcessRenewalsController {
	
	@Autowired
	AddProcessRenewalsService addProcessRenewalsService;
	
	@GetMapping("/getAllAddProcessRenewals")
	public ResponseEntity<?> getAllAddProcessRenewals() {
		return ResponseEntity.ok(addProcessRenewalsService.getAllAddProcessRenewals());
	}
	
	@PostMapping("/saveAddProcessRenewals")
	public ResponseEntity<?> saveAddProcessRenewals(@RequestBody AddProcessRenewalsVO id) throws Exception {
		return ResponseEntity.ok(addProcessRenewalsService.saveAddProcessRenewals(id));
	}
	
	@PostMapping("/getAllAddProcessRenewalsForPublisher")
	public ResponseEntity<?> getAllAddRenewalsForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(addProcessRenewalsService.getAllAddProcessRenewalsForPublisher(pubId));
	}
	
	@PostMapping("/updateAddProcessRenewals")
	public ResponseEntity<?> updateAddProcessRenewals(@RequestBody AddProcessRenewalsVO addRenewalProcess) {
		return ResponseEntity.ok(addProcessRenewalsService.updateAddProcessRenewals(addRenewalProcess));	
		}
	
	@PostMapping("/findbyAddProcessRenewalsId")
	public ResponseEntity<?> findbyAddProcessRenewalsId(@RequestBody Integer id) {
		return ResponseEntity.ok(addProcessRenewalsService.findbyAddProcessRenewalsId(id));
	}
	
	@DeleteMapping("/deletebyAddProcessRenewalsId")
	public ResponseEntity<?> deleteByAddProcessRenewalsId(@RequestBody Integer id) {
		return ResponseEntity.ok(addProcessRenewalsService.deleteByAddProcessRenewalsId(id));
	}

}
