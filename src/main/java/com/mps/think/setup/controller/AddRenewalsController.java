package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import com.mps.think.setup.model.AddRenewals;
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
	
//	@PostMapping("/getAllAddRenewalsForPublisher")
//	public ResponseEntity<?> getAllAddRenewalsForPublisher(@RequestBody Integer pubId) {
//		return ResponseEntity.ok(addRenewalsService.getAllAddRenewalsForPublisher(pubId));
//	}
	
	@GetMapping("/getAllAddRenewalsForPublisher/{pubId}")
	public ResponseEntity<?> getAllAddRenewalsForPublisher(@PathVariable("pubId") Integer pubId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(addRenewalsService.getAllAddRenewalsForPublisher(pubId,
				PageRequest.of(page, size)));
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
		return ResponseEntity.ok(addRenewalsService.findbyAddRenewalsId(id));
	}
	
	@DeleteMapping("/deleteAddRenewals")
	public ResponseEntity<?> deleteRenewalCard(@RequestBody Integer renewalCardId) {
		return ResponseEntity.ok(addRenewalsService.deleteAddRenewals(renewalCardId));
	}
	
//	@DeleteMapping("/deleteAddRenewals")
//	public ResponseEntity<?> deleteRenewalCard(@RequestBody Integer renewalCardId,
//			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size){
//		return ResponseEntity.ok(addRenewalsService.deleteAddRenewals(renewalCardId,
//				PageRequest.of(page, size)));
//	}
	


}
