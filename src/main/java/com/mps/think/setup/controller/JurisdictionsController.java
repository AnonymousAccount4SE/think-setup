package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.JurisdictionsService;
import com.mps.think.setup.vo.JurisdictionsVO;

@RestController
@CrossOrigin
public class JurisdictionsController {
	
	@Autowired
	JurisdictionsService jurisdictionsService;
	
	@GetMapping("/getAlljurisdictions")
	public ResponseEntity<?> getAlljurisdictions() {
		return ResponseEntity.ok(jurisdictionsService.findAllJurisdictions());
	}
	
	@PostMapping("/savejurisdictions")
	public ResponseEntity<?> savejurisdictions(@RequestBody JurisdictionsVO id) {
		return ResponseEntity.ok(jurisdictionsService.saveJurisdictions(id));
	}
	
	@PostMapping("/updatejurisdictions")
	public ResponseEntity<?> updatejurisdictions(@RequestBody JurisdictionsVO id) {
		return ResponseEntity.ok(jurisdictionsService.updateJurisdictions(id));
	}
	
	@PostMapping("/findbyjurisdictionsId")
	public ResponseEntity<?> findbyId(@RequestBody Integer id) {
		return ResponseEntity.ok(jurisdictionsService.findbyId(id));
	}
	
	@DeleteMapping("/deleteByJurisdictionsId")
	public ResponseEntity<?> deleteJurisdictionsById(@RequestBody Integer id) {
		return ResponseEntity.ok(jurisdictionsService.deleteJurisdictionsById(id));
	}
	
	@PostMapping("/getAllJurisdictionsForPublisher")
	public ResponseEntity<?> findAllJurisdictionsForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(jurisdictionsService.findAllJurisdictionsForPublisher(pubId));
	}
	
	@PostMapping("/findbyJurisdictionStateTaxContry")
	public ResponseEntity<?> findbyId(@RequestBody JurisdictionsVO JurisdictionVo ) {
		return ResponseEntity.ok(jurisdictionsService.findbyJurisdictionStateTaxContry(JurisdictionVo));
	}

	@GetMapping("/getAllcountrybyJurisdiction")
	public ResponseEntity<?> findbyId() {
		return ResponseEntity.ok(jurisdictionsService.getAllcountrybyJurisdiction());
	}
	@PostMapping("/getAllStateByJurisdiction")
	public ResponseEntity<?> getAllStateByJurisdiction(@RequestBody String country ) {
		return ResponseEntity.ok(jurisdictionsService.getAllStateByJurisdiction(country));
	}
}
