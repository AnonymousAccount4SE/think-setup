package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@PostMapping("/saveAddProcessRenewals")
	public ResponseEntity<?> saveAddProcessRenewals(@RequestBody AddProcessRenewalsVO id) {
		return ResponseEntity.ok(addProcessRenewalsService.saveAddProcessRenewals(id));
	}
	
	@PostMapping("/getAllAddProcessRenewalsForPublisher")
	public ResponseEntity<?> getAllAddRenewalsForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(addProcessRenewalsService.getAllAddProcessRenewalsForPublisher(pubId));
	}

}
