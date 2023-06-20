package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.AddRenewalsService;
import com.mps.think.setup.vo.AddRenewalsVO;


@RestController
@CrossOrigin
public class AddRenewalsController {
	
	@Autowired
	AddRenewalsService addRenewalsService;
	
	@GetMapping("/getAllAddRenewals")
	public ResponseEntity<?> findAllAddRenewals() {
		return ResponseEntity.ok(addRenewalsService.findAllAddRenewals());
	}
	
	@PostMapping("/getAllAddRenewalsForPublisher")
	public ResponseEntity<?> getAllAddRenewalsForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(addRenewalsService.getAllAddRenewalsForPublisher(pubId));
	}

	@PostMapping("/saveAddRenewals")
	public ResponseEntity<?> saveRenewalCard(@RequestBody AddRenewalsVO cardVO) {
		return ResponseEntity.ok(addRenewalsService.saveAddRenewals(cardVO));
	}
	
	@PutMapping("/updateAddRenewals")
	public ResponseEntity<?> updateRenewalCard(@RequestBody AddRenewalsVO cardVO) {
		return ResponseEntity.ok(addRenewalsService.updateAddRenewals(cardVO));
	}
	
	@PostMapping("/findbyAddRenewalsId")
	public ResponseEntity<?> findbyRenewalCardId(@RequestBody Integer id) {
		return ResponseEntity.ok(addRenewalsService.findbyRenewalCardId(id));
	}
	
	@DeleteMapping("/deleteAddRenewals")
	public ResponseEntity<?> deleteRenewalCard(@RequestBody Integer renewalCardId) {
		return ResponseEntity.ok(addRenewalsService.deleteRenewalCard(renewalCardId));
	}

}
